package com.example.execution;

import org.apache.bcel.classfile.Method;

import com.example.runtimeAreas.threads.JavaThread;
import com.example.runtimeAreas.threads.StackFrame;
import com.example.utils.Printing;
import static com.example.execution.InstructionsLibrary.*;

public class ExecutionEngine {
    public static void executeMethod(JavaThread thread, Method method) {
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
                    int one = byteCode[i + 1];
                    one = one << 8;
                    sipush((short)(one + byteCode[i+2]), currentFrame);
                    i= i + 2;
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
                case 159:
                    if (if_icmpeq(currentFrame)) {
                        int one1 = byteCode[i + 1];
                        one1 = one1 << 8;
                        i = (one1 + byteCode[i + 2]) - 1;
                    } else {
                        i = i + 3;
                    }

                    break;
                case 167:
                    int one = byteCode[i + 1];
                    one = one << 8;
                    i = (one + byteCode[i + 2]) - 1;
                    break;
                case 177:
                    // code for return
                    break;
                default:
                    break;
            }
        }
        Printing.printArray(thread.getCurrentFrame().getOperandStack().toArray());
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
}
