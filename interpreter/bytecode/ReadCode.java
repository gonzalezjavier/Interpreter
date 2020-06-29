package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

//read input from the user and checks if it is a proper input

public class ReadCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        Scanner scanner = new Scanner(System.in);
        int check = 0;
        String input;
        System.out.println("Please enter an integer: ");
        do {
            input = scanner.next();
            try {
                Integer.parseInt(input);
                check++;
            } catch (Exception exception) {
                System.out.println("Please enter a valid integer.");
            }
        } while (check == 0);
        virtualMachine.pushRunTimeStack(Integer.parseInt(input));
    }

    @Override
    public String toString(VirtualMachine virtualMachine) {
        return "READ" + '\n';
    }
}
