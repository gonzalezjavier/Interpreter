package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//displays the top number of the RTS to console

public class WriteCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.peekRunTimeStack());
    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        return "WRITE" + '\n';
    }
}
