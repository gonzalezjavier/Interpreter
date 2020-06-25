package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//takes one arg, a label to jump to
//ex: CALL label<<int>>
//call code must go through address resolution to figure out where it needs to jump to
//must store a return address on the RAS
//must jump to the address in the program that corresponds to the label
//dump specs
public class CallCode extends ByteCode {
    private String label;
    private int retAddress;

    public int getRetAddress() {
        return retAddress;
    }

    public void setRetAddress(int retAddress) {
        this.retAddress = retAddress;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushReturnAddress(virtualMachine.getProgramCounter());
        virtualMachine.setProgramCounter(retAddress);
    }
}
