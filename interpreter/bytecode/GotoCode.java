package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//takes one argument, a label to jump to
//Ex: GOTO label<<int>>
//the label must have its address resolved before the program begins executing
//if dump is on, required to be dumped


public class GotoCode extends ByteCode{
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
        virtualMachine.setProgramCounter(retAddress);
    }
}
