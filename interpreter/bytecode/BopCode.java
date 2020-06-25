package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String operation;

    @Override
    public void init(ArrayList<String> args) {
        operation = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int secondNum = virtualMachine.popRunTimeStack();
        int firstNum = virtualMachine.popRunTimeStack();

        if ("+".equals(operation)) {
            virtualMachine.pushRunTimeStack(firstNum + secondNum);
        } else if ("-".equals(operation)) {
            virtualMachine.pushRunTimeStack(firstNum - secondNum);
        } else if ("/".equals(operation)) {
            virtualMachine.pushRunTimeStack(firstNum / secondNum);
        } else if ("*".equals(operation)) {
            virtualMachine.pushRunTimeStack(firstNum * secondNum);
        } else if ("==".equals(operation)) {
            if (firstNum == secondNum) {
                virtualMachine.pushRunTimeStack(1);
            } else {
                virtualMachine.pushRunTimeStack(0);
            }
        } else if ("!=".equals(operation)) {
            if (firstNum != secondNum) {
                virtualMachine.pushRunTimeStack(1);
            } else {
                virtualMachine.pushRunTimeStack(0);
            }
        } else if ("<=".equals(operation)) {
            if (firstNum <= secondNum) {
                virtualMachine.pushRunTimeStack(1);
            } else {
                virtualMachine.pushRunTimeStack(0);
            }
        } else if (">".equals(operation)) {
            if (firstNum > secondNum) {
                virtualMachine.pushRunTimeStack(1);
            } else {
                virtualMachine.pushRunTimeStack(0);
            }
        } else if (">=".equals(operation)) {
            if (firstNum >= secondNum) {
                virtualMachine.pushRunTimeStack(1);
            } else {
                virtualMachine.pushRunTimeStack(0);
            }
        } else if ("<".equals(operation)) {
            if (firstNum < secondNum) {
                virtualMachine.pushRunTimeStack(1);
            } else {
                virtualMachine.pushRunTimeStack(0);
            }
        } else if ("|".equals(operation)) {
            if (firstNum == 1 | secondNum == 1) {
                virtualMachine.pushRunTimeStack(1);
            } else {
                virtualMachine.pushRunTimeStack(0);
            }
        } else if ("&".equals(operation)) {
            if (firstNum == 1 && secondNum == 1) {
                virtualMachine.pushRunTimeStack(1);
            } else {
                virtualMachine.pushRunTimeStack(0);
            }
        }

    }
}
