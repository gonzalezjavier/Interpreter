package interpreter.virtualmachine;

import java.util.ArrayList;
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
        return this.runTimeStack.get(this.runTimeStack.size() - 1);
    }

    /**
     * removes the top value of the runtime stack
     *
     * @return the value removed
     */
    public int pop() {
        try {
            return this.runTimeStack.remove(this.runTimeStack.size() - 1);
        } catch (Exception exception) {
            return 0;
        }
    }

    /**
     * used for dumping the current state of the runTimeStack.
     * It will print portions of the stack based on respective
     * frame markers.
     * Example [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0,3,6
     **/
    public void dump() {

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
}
