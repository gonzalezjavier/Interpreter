package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//takes one argument, a label to jump to
//label will need to be resolved to be an int value of label address
//Remove the top value of stack: if 0 -> jump to label , if not 0 -> move to next ByteCode

public class FalseBranchCode extends ByteCode {
    private String label;
    private int retAddress;

    public void setRetAddress(int retAddress) {
        this.retAddress = retAddress;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if (virtualMachine.popRunTimeStack() == 0) {
            virtualMachine.setProgramCounter(retAddress);
        }

    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        return "FALSEBRANCH " + label + '\n';
    }
}
