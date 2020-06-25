package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//can have 1 or 2 arguments: 1 arg is the offset in the current frame where the value that is popped
//      is to be stored
// 2 arg, if present, is the identifier(variable) the value belongs to. this is used for dumping
//store must pop the top of the RTS and store the value at the offset in the current frame
//store cannot operate across frame boundaries
//if dump is on, store needs to be dumped according to the specs given in dumping format
public class StoreCode extends ByteCode {
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
        virtualMachine.storeRunTimeStack(offset);
    }
}
