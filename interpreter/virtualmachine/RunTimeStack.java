package interpreter.virtualmachine;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }


    /**
     * Push the value to the top of the stack
     *
     * @param value the value to be pushed
     * @return the value pushed
     */
    public int push(int value) {
        this.runTimeStack.add(value);
        return this.peek();
    }

    /**
     * returns the top of the runtime stack, but does not remove the value
     *
     * @return copy of the top of the stack
     */
    public int peek() {
        if (!this.runTimeStack.isEmpty()) {
            return this.runTimeStack.get(this.runTimeStack.size() - 1);
        } else {
            return 0;
        }

    }

    /**
     * removes the top value of the runtime stack
     *
     * @return the value removed
     */
    public int pop() {
        return this.runTimeStack.remove(this.runTimeStack.size() - 1);
    }

    /**
     * used for dumping the current state of the runTimeStack.
     * It will print portions of the stack based on respective
     * frame markers.
     * Example [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0,3,6
     **/
    public void dump() {
        if (!runTimeStack.isEmpty()) {
            //push an imaginary frame boundary that is the RTS.size()
            //iterate through from beg to end of frame and then set the new values
            //for beg and end to correspond to the new frames beginning and end
            framePointer.push(runTimeStack.size());
            int beg = framePointer.get(0);
            int end;

            int i = 1;
            while (i < framePointer.size()) {
                //start of a new frame
                end = framePointer.get(i);
                System.out.print('[');
                while (beg < end) {
                    //check if on the last number in the frame to avoid syntax errors
                    if (beg == end - 1) {
                        System.out.print(runTimeStack.get(beg++));
                    } else {
                        System.out.print(runTimeStack.get(beg++) + ",");
                    }
                }
                System.out.print(']');
                i++;
            }
            System.out.println();
            //remove the frame pointer added in beginning
            framePointer.pop();
        } else {
            System.out.println("[]");
        }
    }

    /**
     * Takes the top item off the runTimeStack, and stores
     * it into an offset starting from the current frame.
     *
     * @param offset number of slots above current frame marker
     * @return the item just stored
     */
    public int store(int offset) {
        int address;
        int value;
        value = this.runTimeStack.remove(this.runTimeStack.size() - 1);
        address = this.framePointer.peek() + offset;
        this.runTimeStack.add(address, value);
        runTimeStack.remove(runTimeStack.size() - 1);

        return value;
    }

    /**
     * Takes a value from the runTimeStack that is at offset
     * from the current frame marker and pushes it onto the top
     * of the stack.
     *
     * @param offset number of slots above current frame marker
     * @return item just loaded into the offset
     */
    public int load(int offset) {
        int address;
        int value;

        address = this.framePointer.peek() + offset;
        value = this.runTimeStack.get(address);
        this.runTimeStack.add(value);
        return value;
    }

    /**
     * create a new frame pointer at the index offset slots down
     * from the top of the runtime stack.
     *
     * @param offset slots down from the top of the runtime stack
     */
    public void newFrameAt(int offset) {
        this.framePointer.push(this.runTimeStack.size() - offset);
    }

    /**
     * pop the current frame off the runtime stack. Also removes
     * the frame pointer value from the FramePointer Stack.
     */
    public void popFrame() {
        int address;
        int lastElement = runTimeStack.get(runTimeStack.size() - 1);
        address = this.framePointer.pop();
        for (int i = this.runTimeStack.size() - 1; i >= address; i--) {
            this.runTimeStack.remove(i);
        }
        runTimeStack.add(lastElement);
    }

    /**
     * this is for printing out the top frame of the runtime stack
     * to get the arguments going into the next function
     *
     * @return the top frame of the runtime stack
     */
    public ArrayList<Integer> getTopRuntimeStackFrame() {
        ArrayList<Integer> topFrame = new ArrayList<>();
        if (!runTimeStack.isEmpty()) {
            int address;
            int lastElement = runTimeStack.get(runTimeStack.size() - 1);
            address = this.framePointer.peek();
            for (int i = this.runTimeStack.size() - 1; i >= address; i--) {
                topFrame.add(this.runTimeStack.get(i));
            }
        }
        return topFrame;
    }

}
