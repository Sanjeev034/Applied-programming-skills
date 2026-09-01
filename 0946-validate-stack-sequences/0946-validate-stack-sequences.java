import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int pushVal : pushed) {
            stack.push(pushVal);
            while (!stack.isEmpty() && popIndex < popped.length && stack.peek() == popped[popIndex]) {
                stack.pop(); 
                popIndex++; 
            }
        }
        return stack.isEmpty();
    }
}
