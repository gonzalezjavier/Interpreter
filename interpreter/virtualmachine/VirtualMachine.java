package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private Program program;
    private int programCounter;
    private boolean isRunning;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            programCounter++;
        }
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(int n) {
        programCounter = n;
    }

    public int popRunTimeStack() {
        return runTimeStack.pop();
    }

    public int peekRunTimeStack() {
        return runTimeStack.peek();
    }

    public void pushRunTimeStack(int n) {
        runTimeStack.push(n);
    }

    public void loadRunTimeStack(int offset) {
        runTimeStack.load(offset);
    }

    public void storeRunTimeStack(int offset) {
        runTimeStack.store(offset);
    }

    public void newFrame(int i) {
        runTimeStack.newFrameAt(i);
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public void pushReturnAddress(int i) {
        returnAddress.push(i);
    }

    public int popReturnAddress() {
        return returnAddress.pop();
    }

    public void haltProgram() {
        isRunning = false;
    }

}
