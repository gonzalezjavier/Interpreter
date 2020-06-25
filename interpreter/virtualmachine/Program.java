package interpreter.virtualmachine;

import interpreter.bytecode.*;

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
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<String> value = new ArrayList<>();
        //two for loops and you can do nested for loops
        //1st pass through the arrayList keeping track of label codes and their labels
        for (int i = 0; i < this.program.size(); i++) {
            if (this.program.get(i) instanceof LabelCode) {
                index.add(i);
                value.add(((LabelCode) this.program.get(i)).getLabel());
            }
        }
        //2nd pass through arrayList look for call, goto, and falsebranch code and do the following:
        //look at stored label codes and find the 1 that has the matching label
        for (int j = 0; j < this.program.size(); j++) {
            if (this.program.get(j) instanceof CallCode) {
                for (int k = 0; k < value.size(); k++) {
                    if (value.get(k).equals(((CallCode) this.program.get(j)).getLabel())) {
                        ((CallCode) this.program.get(j)).setRetAddress(index.get(k));
                    }
                }
            } else if (this.program.get(j) instanceof GotoCode) {
                for (int k = 0; k < value.size(); k++) {
                    if (value.get(k).equals(((GotoCode) this.program.get(j)).getLabel())) {
                        ((GotoCode) this.program.get(j)).setRetAddress(index.get(k));
                    }
                }
            } else if (this.program.get(j) instanceof FalseBranchCode) {
                for (int k = 0; k < value.size(); k++) {
                    if (value.get(k).equals(((FalseBranchCode) this.program.get(j)).getLabel())) {
                        ((FalseBranchCode) this.program.get(j)).setRetAddress(index.get(k));
                    }
                }

            }
        }

    }

    /**
     * this adds bytecode to the arraylist
     *
     * @param bc is the bytecode to be added
     */
    public void add(ByteCode bc) {
        this.program.add(bc);
    }
}
