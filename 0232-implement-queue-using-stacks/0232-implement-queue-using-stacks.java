class MyQueue {
    private Stack<Integer> mainStack;
    private Stack<Integer> helperStack;
    public MyQueue() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
        
    }
    
    public void push(int x) {
        while(!mainStack.isEmpty()){
            helperStack.push(mainStack.pop());
        }
        mainStack.push(x);
        while(!helperStack.isEmpty()){
            mainStack.push(helperStack.pop());
        }
    }
    
    public int pop() {
        if(mainStack.isEmpty()){
            return -1;
        }
        int frontValue = mainStack.peek();
        mainStack.pop();
        return frontValue;
    }
    
    public int peek() {
        if(mainStack.isEmpty()){
            return -1;
        }
        return mainStack.peek();
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */