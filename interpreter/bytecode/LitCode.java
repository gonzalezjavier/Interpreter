package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//1 or 2 args
//should only push one value to the top of the RTS
//the 2nd arg is the identifier associated with the literal
public class LitCode extends ByteCode {
    private int value;
    private String identifier;

    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            identifier = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushRunTimeStack(value);
    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        String base = "LIT " + value;
        if (identifier != null) {
            base += (" " + identifier + "\tint " + identifier);
        }
        return base + '\n';
    }
}