package edu.isu.cs.cs3308.structures;

/**
 * A stack created using a DoublyLinkedList structure. The top of the stack
 * is the most recent element added to the list at the head of the list. All
 * operations affect only the top of the stack.
 *
 * @author Andrew Aikens
 * @param <E> Element type
 */
public class LinkedStack<E> implements Stack<E> {

    private DoublyLinkedList<E> stack;

    public LinkedStack(){
        stack = new DoublyLinkedList<>();
    }

    /**
     * Adds the provided item to the top of the stack. Note that if the item is
     * null, nothing occurs.
     *
     * @param element Element added to the top of the stack, unless this item is
     * null.
     */
    @Override
    public void push(E element) {
        stack.addFirst(element);
    }

    /**
     * Returns the value of the top item in the stack, without removing it. If
     * the stack is empty then null is returned.
     *
     * @return The value of the item at the top of the stack, or null if the
     * stack is empty.
     */
    @Override
    public E peek() {
        return stack.first();
    }

    /**
     * Removes the top item from the stack and returns it's value. If the stack
     * is currently empty, null is returned.
     *
     * @return The value of the top item in the stack, or null if the stack is
     * empty.
     */
    @Override
    public E pop() {
        return stack.removeFirst();
    }

    /**
     * @return The current number of items in this stack.
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * A test to determine if this Stack is currently empty.
     *
     * @return True if this stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Transfers the contents of this stack into the provided stack. The contents
     * of this stack are to found in reverse order at the top of the provided
     * stack. This stack should be empty once the transfer is completed. Note
     * that if the provided stack is null, nothing is to happen.
     *
     * @param to The new stack onto which the reversed order of contents from
     * this stack are to be transferred to the top of, unless the provided stack
     * is null.
     */
    @Override
    public void transfer(Stack<E> to) {
        if(to == null)
            return;
        while(size() > 0)
            to.push(pop());
    }

    /**
     * Reverses the contents of this stack.
     */
    @Override
    public void reverse() {
        LinkedStack<E> temp1 = new LinkedStack<>();
        LinkedStack<E> temp2 = new LinkedStack<>();
        transfer(temp1);
        temp1.transfer(temp2);
        temp2.transfer(this);
    }

    /**
     * Merges the contents of the provided stack onto the bottom of this stack.
     * The order of both stacks must be preserved in the order of this stack
     * after the method call. Furthermore, the provided stack must still contain
     * its original contents in their original order after the method is
     * complete. If the provided stack is null, no changes should occur.
     *
     * @param from Stack whose contents are to be merged onto the bottom of
     * this stack.
     */
    @Override
    public void merge(Stack<E> from) {
        if(from == null)
            return;
        reverse();
        E element;
        Stack<E> temp1 = new LinkedStack<>();
        Stack<E> temp2 = new LinkedStack<>();
        while(from.size() > 0) {
            element = from.pop();
            temp1.push(element);
            temp2.push(element);
        }
        temp1.reverse();
        temp2.transfer(from);
        while(temp1.size() > 0)
            push(temp1.pop());
        reverse();
    }

    /**
     * Prints the contents of the stack starting at top, one item per line. Note
     * this method should not empty the contents of the stack.
     */
    @Override
    public void printStack() {
        stack.printList();
    }
}