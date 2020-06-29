package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//sole purpose is to mark locations to jump to in code
public class LabelCode extends ByteCode {
    private String label;

    public String getLabel() {
        return label;
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        return "LABEL " + label + "\n";
    }
}
