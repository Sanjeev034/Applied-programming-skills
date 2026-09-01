import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = Arrays.copyOf(prices, prices.length); 
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = prices[prevIndex] - prices[i];
            }
            stack.push(i);
        }
        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna