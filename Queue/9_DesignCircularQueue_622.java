// LeetCode 622 - Design Circular Queue
// Difficulty: Medium
// Problem: Implement a circular queue without using built-in queue
// What to do: Support enqueue, dequeue, front, rear, isEmpty, isFull
// How it works:
// - Use a fixed-size array
// - Maintain front, rear pointers and count
// - Use modulo (%) for circular movement
// Concept Used: Queue, Circular Array, Modulo Arithmetic
// Time Complexity: O(1) for all operations
// Space Complexity: O(k)
class MyCircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;
    int count;

    public MyCircularQueue(int k) {
        size = k;
        queue = new int[k];
        front = 0;
        rear = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % size;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size;
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(rear - 1 + size) % size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}
