package com.example.execution;

import org.apache.bcel.classfile.Method;

import com.example.runtimeAreas.threads.JavaThread;
import com.example.runtimeAreas.threads.StackFrame;
import com.example.utils.Printing;
import static com.example.execution.InstructionsLibrary.*;

/*
 *  there is two proposed implementation 
 * one is to use one execution loop per thread and use the 
 * frame data to call and return from methods.
 * two is to use one execution loop per method and use the excecution loop 
 * itself to transform return and call info rather than the frame data.
 * 
 * for now i will stick with the second implementation.  
*/
public class ExecutionEngine {
    public static void executeMethod(JavaThread thread, Method method) throws Exception {
        byte[] byteCode = method.getCode().getCode();
        StackFrame currentFrame = thread.getCurrentFrame();
        for (int i = 0; i < byteCode.length; i++) {
            switch ((int) byteCode[i]) {
                case 1:
                    // code for pushing null into the stack.
                    break;
                case 2:
                    iconst_m1(currentFrame);
                    break;
                case 3:
                    iconst_0(currentFrame);
                    break;
                case 4:
                    iconst_1(currentFrame);
                    break;
                case 5:
                    iconst_2(currentFrame);
                    break;
                case 6:
                    iconst_3(currentFrame);
                    break;
                case 7:
                    iconst_4(currentFrame);
                    break;
                case 8:
                    iconst_5(currentFrame);
                    break;
                case 16:
                    bipush(byteCode[i + 1], currentFrame);
                    i++;
                    break;
                case 17:
                    sipush(getTheNextShortValue(byteCode, i), currentFrame);
                    i = i + 2;
                    break;
                case 21:
                    iload(byteCode[i + 1], currentFrame);
                    i++;
                    break;
                case 26:
                    iload_0(currentFrame);
                    break;
                case 27:
                    iload_1(currentFrame);
                    break;
                case 28:
                    iload_2(currentFrame);
                    break;
                case 29:
                    iload_3(currentFrame);
                    break;
                case 54:
                    istore(byteCode[i + 1], currentFrame);
                    i++;
                    break;
                case 59:
                    istore_0(currentFrame);
                    break;
                case 60:
                    istore_1(currentFrame);
                    break;
                case 61:
                    istore_2(currentFrame);
                    break;
                case 62:
                    istore_3(currentFrame);
                    break;
                case 87:
                    pop(currentFrame);
                    break;
                case 88:
                    pop2(currentFrame);
                    break;
                case 89:
                    dup(currentFrame);
                    break;
                case 92:
                    dup2(currentFrame);
                    break;
                case 95:
                    swap(currentFrame);
                    break;
                case 96:
                    iadd(currentFrame);
                    break;
                case 100:
                    isub(currentFrame);
                    break;
                case 104:
                    imul(currentFrame);
                    break;
                case 108:
                    idiv(currentFrame);
                    break;
                case 112:
                    irem(currentFrame);
                    break;
                case 116:
                    ineg(currentFrame);
                    break;
                case 120:
                    ishl(currentFrame);
                    break;
                case 122:
                    ishr(currentFrame);
                    break;
                case 124:
                    iushr(currentFrame);
                    break;
                case 128:
                    ior(currentFrame);
                    break;
                case 130:
                    ixor(currentFrame);
                    break;
                case 132:
                    iinc(currentFrame, byteCode[i + 1], byteCode[i + 2]);
                    i = i + 2;
                    break;

                case 159:
                    if (if_icmpeq(currentFrame)) {
                        i = jumpTo(byteCode, i);
                    } else {
                        i = i + 2;
                    }
                    break;
                case 160: // if_icmpne
                    if (if_icmpne(currentFrame)) {
                        i = jumpTo(byteCode, i);
                    } else {
                        i = i + 2;
                    }
                case 161: // if_icmplt
                    if (if_icmplt(currentFrame)) {
                        i = jumpTo(byteCode, i);
                    } else {
                        i = i + 2;
                    }
                    break;
                case 162: // if_icmpge
                    if (if_icmpge(currentFrame)) {
                        i = jumpTo(byteCode, i);
                    } else {
                        i = i + 2;
                    }
                    break;
                case 163: // if_icmpgt
                    if (if_icmpgt(currentFrame)) {
                        i = jumpTo(byteCode, i);
                    } else {
                        i = i + 2;
                    }
                    break;
                case 164: // if_icmple
                    if (if_icmple(currentFrame)) {
                        i = jumpTo(byteCode, i);
                    } else {
                        i = i + 2;
                    }
                    break;
                case 167: // goto
                    i = jumpTo(byteCode, i);
                    break;
                case 177:
                    // code for return
                    break;
                default:
                    throw new Exception("unsupported operation");
            }
            Printing.printFrame(currentFrame);
        }
    }

    // method for creating the frame to a new method and pass the args to it.
    public static void callMethod(JavaThread thread, Method method, Object[] args) {

        // creation of the stack for the new method in the same thread.
        StackFrame currentFrame = thread.createStackFrame(method
                .getLocalVariableTable()
                .getTableLength());

        // passing args to it.
        if (method.getName().equals("main")) {
            passArgs(args, currentFrame.getLocalVars(), true);
        } else {
            // code for any static method passing args
        }
        Printing.printArray(currentFrame.getLocalVars());
    }

    private static void passArgs(Object[] callerArgs, Object[] calledLocals, boolean isStatic) {
        int index;
        if (isStatic) {
            index = 0;
        } else {
            index = 1;
        }
        for (Object object : callerArgs) {
            calledLocals[index] = object;
        }
    }

    // jump to index that is a signed short value that come after the byte code of i
    private static int jumpTo(byte[] byteCode, int i) { // i is the current index.
        int one = byteCode[i + 1];
        one = one << 8;
        return (one + byteCode[i + 2]) - 1;
    }

    private static short getTheNextShortValue(byte[] byteCode, int i) { // i is the current index.
        int one = byteCode[i + 1];
        one = one << 8;
        return (short) (one + byteCode[i + 2]);
    }
}
