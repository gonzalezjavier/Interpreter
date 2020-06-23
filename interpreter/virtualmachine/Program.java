package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        //two for loops and you can do nested for loops

        //1st pass through the arrayList keeping track of label codes and their labels

        //2nd pass through arrayList look for call, goto, and falsebranch code and do the following:
        //look at stored label codes and find the 1 that has the matching label
    }




}
