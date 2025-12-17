// LeetCode 232 - Implement Queue using Stacks
// Difficulty: Easy
// Problem: Implement a FIFO queue using only stack operations
// What to do: Support push, pop, peek, and empty
// How it works:
// - Use two stacks: inStack and outStack
// - Push elements into inStack
// - When popping/peeking, move elements to outStack if needed
// Concept Used: Stack, Queue Simulation, Amortized Analysis
// Time Complexity:
// - Push: O(1)
// - Pop/Peek: Amortized O(1)
// Space Complexity: O(n)
import java.util.Stack;

class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
