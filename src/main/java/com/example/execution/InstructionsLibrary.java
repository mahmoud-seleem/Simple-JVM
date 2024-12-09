package com.example.execution;

import org.apache.bcel.classfile.Method;

import com.example.runtimeAreas.threads.JavaThread;
import com.example.runtimeAreas.threads.StackFrame;

public class InstructionsLibrary {
    // pushing value to stack
    public static void interpretByeCode(byte byteCode, JavaThread thread, Method method) {
        StackFrame currentFrame = thread.getCurrentFrame();

    }

    public static void iconst_0(StackFrame frame) {
        frame.push((int) 0);
    }

    public static void iconst_1(StackFrame frame) {
        frame.push((int) 1);
    }

    public static void iconst_2(StackFrame frame) {
        frame.push((int) 2);
    }

    public static void iconst_3(StackFrame frame) {
        frame.push((int) 3);
    }

    public static void iconst_4(StackFrame frame) {
        frame.push((int) 4);
    }

    public static void iconst_5(StackFrame frame) {
        frame.push((int) 5);
    }

    public static void iconst_m1(StackFrame frame) {
        frame.push((int) -1);
    }

    public static void iload(int index, StackFrame frame) {
        frame.push(frame.getLocalAt(index));
    }

    public static void iload_0(StackFrame frame) {
        frame.push(frame.getLocalAt(0));
    }

    public static void iload_1(StackFrame frame) {
        frame.push(frame.getLocalAt(1));
    }

    public static void iload_2(StackFrame frame) {
        frame.push(frame.getLocalAt(2));
    }

    public static void iload_3(StackFrame frame) {
        frame.push(frame.getLocalAt(3));
    }

    public static void istore(int index, StackFrame frame) {
        frame.setLocalAt(frame.pop(), index);
    }

    public static void istore_0(StackFrame frame) {
        frame.setLocalAt(frame.pop(), 0);
    }

    public static void istore_1(StackFrame frame) {
        frame.setLocalAt(frame.pop(), 1);
    }

    public static void istore_2(StackFrame frame) {
        frame.setLocalAt(frame.pop(), 2);
    }

    public static void istore_3(StackFrame frame) {
        frame.setLocalAt(frame.pop(), 3);
    }

    public static void pop(StackFrame frame) {
        frame.pop();
    }

    public static void pop2(StackFrame frame) {
        frame.pop();
        frame.pop();
    }

    public static void dup(StackFrame frame) {
        frame.push(frame.peek());
    }

    public static void dup2(StackFrame frame) {
        Object o1 = frame.pop();
        Object o2 = frame.peek();
        frame.push(o1);
        frame.push(o2);
        frame.push(o1);
    }

    public static void swap(StackFrame frame) {
        Object top = frame.pop();
        Object sec = frame.pop();
        frame.push(top);
        frame.push(sec);
    }

    public static void iadd(StackFrame frame) {
        Object top = frame.pop();
        Object sec = frame.pop();
        if (top instanceof Integer && sec instanceof Integer) {
            frame.push((int) top + (int) sec);
            return;
        }
        throw new ArithmeticException("not appropriate operands");
    }

    public static void isub(StackFrame frame) {
        Object top = frame.pop();
        Object sec = frame.pop();
        if (top instanceof Integer && sec instanceof Integer) {
            frame.push((int) sec - (int) top);
            return;
        }
        throw new ArithmeticException("not appropriate operands");
    }

    public static void imul(StackFrame frame) {
        Object top = frame.pop();
        Object sec = frame.pop();
        if (top instanceof Integer && sec instanceof Integer) {
            frame.push((int) sec * (int) top);
            return;
        }
        throw new ArithmeticException("not appropriate operands");
    }

    public static void idiv(StackFrame frame) {
        Object top = frame.pop();
        Object sec = frame.pop();
        if (top instanceof Integer && sec instanceof Integer) {
            frame.push((int) sec / (int) top);
            return;
        }
        throw new ArithmeticException("not appropriate operands");
    }

    public static void irem(StackFrame frame) {
        Object top = frame.pop();
        Object sec = frame.pop();
        if (top instanceof Integer && sec instanceof Integer) {
            frame.push((int) sec % (int) top);
            return;
        }
        throw new ArithmeticException("not appropriate operands");
    }

    public static void ineg(StackFrame frame) {
        Object top = frame.pop();
        if (top instanceof Integer) {
            frame.push(-1 * (int) top);
            return;
        }
        throw new ArithmeticException("not appropriate operands");
    }

    public static boolean if_icmpeq(StackFrame frame) {
        int value2 = (int) frame.pop();
        int value1 = (int) frame.pop();

        if (value1 == value2) {
            return true;
        }
        return false;
    }

    public static boolean if_icmpne(StackFrame frame) {
        int value2 = (int) frame.pop();
        int value1 = (int) frame.pop();

        if (value1 != value2) {
            return true;
        }
        return false;
    }

    public static boolean if_icmplt(StackFrame frame) {
        int value2 = (int) frame.pop();
        int value1 = (int) frame.pop();

        if (value1 < value2) {
            return true;
        }
        return false;
    }

    public static boolean if_icmple(StackFrame frame) {
        int value2 = (int) frame.pop();
        int value1 = (int) frame.pop();

        if (value1 <= value2) {
            return true;
        }
        return false;
    }

    public static boolean if_icmpgt(StackFrame frame) {
        int value2 = (int) frame.pop();
        int value1 = (int) frame.pop();

        if (value1 > value2) {
            return true;
        }
        return false;
    }

    public static boolean if_icmpge(StackFrame frame) {
        int value2 = (int) frame.pop();
        int value1 = (int) frame.pop();

        if (value1 <= value2) {
            return true;
        }
        return false;
    }

    public static void bipush(byte byteValue ,StackFrame frame) {
        frame.push(byteValue);
    }

    public static void sipush(short shortval , StackFrame frame){
        frame.push(shortval);
    }
}