package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//can have 1 or 2 args
//  -1 arg is the offset in the current frame where the value is to be copied from
//  -2 arg, if present, the var the value belongs to
//load must copy the value at the offset of the current frame and push it to the top of stack
//load must not remove any values from the RTS
//cannot operate across frame boundaries
//if dump is on, refer to dump specs
public class LoadCode extends ByteCode {
    private int offset;
    private String identifier;


    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        if (args.size() == 2) {
            identifier = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.loadRunTimeStack(offset);
    }
}
