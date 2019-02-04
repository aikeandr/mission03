package edu.isu.cs.cs3308.structures;

/**
 * A queue created using a DoublyLinkedList structure. The top of the queue is
 * the first element added to the queue and will be the first element
 * to be removed.(First IN/First OUT) New elements are added to the end of the
 * underlining DoublyLinkedList, the bottom of the queue.
 *
 * @author Andrew Aikens
 * @param <E> Element type
 */
public class LinkedQueue<E> implements Queue<E> {
    private DoublyLinkedList<E> queue;
    public LinkedQueue(){ queue = new DoublyLinkedList<>(); }

    /**
     * @return The number of elements in the queue
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * @return tests whether the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Inserts an element at the end of the queue.
     *
     * @param element Element to be inserted.
     */
    @Override
    public void offer(E element) {
        queue.addLast(element);
    }

    /**
     * @return The value first element of the queue (with out removing it), or
     * null if empty.
     */
    @Override
    public E peek() {
        return queue.first();
    }

    /**
     * @return The value of the first element of the queue (and removes it), or
     * null if empty.
     */
    @Override
    public E poll() {
        return queue.removeFirst();
    }

    /**
     * Prints the contents of the queue starting at top, one item per line. Note
     * this method should not empty the contents of the queue.
     */
    @Override
    public void printQueue() {
        queue.printList();
    }

    /**
     * Transfers the contents of this queue into the provided queue. The contents
     * of this queue are to found in reverse order at the top of the provided
     * queue. This queue should be empty once the transfer is completed. Note
     * that if the provided queue is null, nothing is to happen.
     *
     * @param into The new queue onto which the reversed order of contents from
     * this queue are to be transferred to the top of, unless the provided queue
     * is null.
     */
    @Override
    public void transfer(Queue<E> into) {
        if(into == null)
            return;
        reverse();
        LinkedStack<E> stack = new LinkedStack<>();
        while(!into.isEmpty())
            stack.push(into.poll());
        while(!isEmpty())
            into.offer(poll());
        stack.reverse();
        while(!stack.isEmpty())
            into.offer(stack.pop());


    }

    /**
     * Reverses the contents of this queue using a stack.
     */
    @Override
    public void reverse() {
        LinkedStack<E> stack = new LinkedStack<>();
        while(!isEmpty())
            stack.push(this.poll());
        while(!stack.isEmpty())
            this.offer(stack.pop());
    }

    /**
     * Merges the contents of the provided queue onto the bottom of this queue.
     * The order of both queues must be preserved in the order of this queue
     * after the method call. Furthermore, the provided queue must still contain
     * its original contents in their original order after the method is
     * complete. If the provided queue is null, no changes should occur.
     *
     * @param from Queue whose contents are to be merged onto the bottom of
     * this queue.
     */
    @Override
    public void merge(Queue<E> from) {
        if(from == null)
            return;
        E element;
        Queue<E> temp1 = new LinkedQueue<>();
        Queue<E> temp2 = new LinkedQueue<>();
        while(!from.isEmpty()) {
            element = from.poll();
            temp1.offer(element);
            temp2.offer(element);
        }
        while(!temp1.isEmpty())
            this.offer(temp1.poll());
        while(!temp2.isEmpty())
            from.offer(temp2.poll());

    }
}
