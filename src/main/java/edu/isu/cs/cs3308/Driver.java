package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Stack;
import edu.isu.cs.cs3308.structures.LinkedQueue;
import edu.isu.cs.cs3308.structures.LinkedStack;

import java.util.Random;

/**
 * Queue Applications
 * @author Isaac Griffith
 * @author 
 */
public class Driver {

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Offering: " + i);
            queue.offer(i);
            queue.printQueue();
            System.out.println();
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println("Polling: " + i);
            queue.poll();
            queue.printQueue();
            System.out.println();
        }

        System.out.println();
        Stack<Integer> stack = new LinkedStack<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println("Current Stack:");
        stack.printStack();
        System.out.println();
        System.out.println("Using Queue to Scan Stack: ");
        for (int i = 0; i < 10; i++) {
            int r = rand.nextInt(20);
            System.out.print("\tScanned for " + r);
            boolean value = StackScan.scanStack(stack, r);

            if (value)
                System.out.println(" and it was found.");
            else
                System.out.println(" but it was not found.");
        }
    }
}
