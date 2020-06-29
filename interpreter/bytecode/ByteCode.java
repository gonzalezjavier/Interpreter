package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {

    //for the ByteCode loader class to pass args associated with a byte code
    public abstract void init(ArrayList<String> args);
    //execution called by the VM class
    public abstract void execute(VirtualMachine virtualMachine);
    //for use when dumping is on
    public abstract String toString(VirtualMachine virtualMachine);
}
