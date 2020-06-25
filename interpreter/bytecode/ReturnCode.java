package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//can take 0 to 1arguments. the args have no effect on its functionality
//only on the dumping process
//must store the value at the top of the RTS
//must empty the current frame of all values when function is complete
//must pop the top value of the frame pointer stack to remove frame boundary
//must pop the top of the RAS and save it into program counter
public class ReturnCode extends ByteCode {
    private String label;

    @Override
    public void init(ArrayList<String> args) {
        if (args.size() == 1) {
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.popFrame();
        virtualMachine.setProgramCounter(virtualMachine.popReturnAddress());
    }
}
