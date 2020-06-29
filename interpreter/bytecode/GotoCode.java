package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//takes one argument, a label to jump to
//the label must have its address resolved before the program begins executing

public class GotoCode extends ByteCode {
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
        virtualMachine.setProgramCounter(retAddress);
    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        return "GOTO " + label + '\n';
    }
}
