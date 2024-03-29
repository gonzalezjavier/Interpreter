package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
//label is ON or OFF
public class DumpCode extends ByteCode {
    private String label;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }


    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.switchDumpState(label);
    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        return "";
    }
}
