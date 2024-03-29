package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//takes no arguments
//notifies the VM that execution needs to be halted
//halt bytecodes are not to be dumped
//cannot execute system.exit call

public class HaltCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.haltProgram();
    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        return "";
    }
}
