public class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1; // Stack is empty initially
    }

    // Push method to add an element to the stack
    public void push(char value) {
        if (top >= maxSize - 1) {
            System.out.println("Stack is full! Cannot push " + value);
            return;
        }
        top++;
        stackArray[top] = value;
        System.out.println("Pushed " + value);
    }

    // Pop method to remove and return the top element of the stack
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return ' '; // Return space character or throw an exception
        }
        char value = stackArray[top];
        top--;
        return value;
    }

    // Peek method to view the top element without removing it
    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return ' '; // Return space character or throw an exception
        }
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top >= maxSize - 1;
    }

}
