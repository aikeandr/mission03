package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.LinkedQueue;

/**
 *
 * @author Isaac Griffith
 * @author Andrew Aikens
 */
public class StackScan {

    /**
     * Tests whether the given stack contains the provided element.
     * Implementation should use a queue to scan the stack and reconstruct it
     * when done.
     *
     * @param <E> Type of elements stored in the stack
     * @param stack Stack to be scanned.
     * @param element Element to search the stack for.
     * @return True if the given stack is not null and contains the given
     * element. Returns false if both the stack and element are not null and the
     * stack does not contain the element, if either the stack or element is
     * null, or if the stack is empty.
     */
    public static <E> boolean scanStack(final Stack<E> stack, E element) {
        if(stack == null || element == null || stack.isEmpty())
            return false;
        boolean found = false;
        Queue<E> queue = new LinkedQueue<>();
        while(!stack.isEmpty() && !found){
            if(stack.peek().equals(element))
                found = true;
            queue.offer(stack.pop());
        }
        queue.reverse();
        while(!queue.isEmpty())
            stack.push(queue.poll());
        return found;
    }
}
