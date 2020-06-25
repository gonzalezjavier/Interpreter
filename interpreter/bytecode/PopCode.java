package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;


//takes one argument which is the number of of values to remove from the runtime stack
//ex: POP 0 so POP int
//not allowed to operate across frame boundaries
//if dump is on, pop is required to be dumped
public class PopCode extends ByteCode {
    private int numToPop;

    @Override
    public void init(ArrayList<String> args) {
        numToPop = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        for (int i = 0; i < numToPop; i++) {
            virtualMachine.popRunTimeStack();
        }
    }
}
