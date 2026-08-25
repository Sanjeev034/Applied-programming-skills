import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // The stack will store indices of the temperatures array.
        Stack<Integer> stack = new Stack<>();

        // Iterate through the temperatures array.
        for (int i = 0; i < n; i++) {
            
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // Pop the index from the stack.
                int prevIndex = stack.pop();
                
                answer[prevIndex] = i - prevIndex;
            }
            
            stack.push(i);
        }

        
        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna