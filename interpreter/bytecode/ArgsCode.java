package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//one arg, the number of values that will be part of the new activation frame
//will need to push the starting index of the new frame to the framePointer stack

public class ArgsCode extends ByteCode {
    private int n;

    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.newFrame(n);
    }
}
