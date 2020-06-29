package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

//takes one arg, a label to jump to
//call code must go through address resolution to figure out where it needs to jump to
//must store a return address on the RAS
//must jump to the address in the program that corresponds to the label
public class CallCode extends ByteCode {
    private String label;
    private int retAddress;

    public void setRetAddress(int retAddress) {
        this.retAddress = retAddress;
    }

    public String getLabel() {
        return label;
    }


    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushReturnAddress(virtualMachine.getProgramCounter());
        virtualMachine.setProgramCounter(retAddress);
    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        String base = "CALL " + label;
        String identifier = "";
        for (int i = 0; i < label.length(); i++) {
            if (label.charAt(i) == '<') {
                break;
            }
            identifier += label.charAt(i);
        }
        base += ('\t' + identifier + '(');
        ArrayList<Integer> args = virtualMachine.getTopRuntimeStackFrame();

        if (!args.isEmpty()) {
            for (int i = args.size() - 1; i >= 1; i--) {
                base += (args.get(i) + ',');

            }
            base += args.get(0);
        }

        base += ")";


        return base + '\n';
    }
}
