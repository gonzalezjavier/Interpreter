package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//takes one argument, a label to jump to
//ex: FALSEBRANCH label<<int>>
//label will need to be resolved to be an int value of label address
//Remove the top value of stack: if 0 -> jump to label , if not 0 -> move to next ByteCode
//if dump is on, required to be dumped

public class FalseBranchCode extends ByteCode {
    private String label;
    private int retAddress;

    public int getRetAddress() {
        return retAddress;
    }

    public void setRetAddress(int retAddress) {
        this.retAddress = retAddress;
    }

    public void setLabel(String label) {
        this.label = label;
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
}
