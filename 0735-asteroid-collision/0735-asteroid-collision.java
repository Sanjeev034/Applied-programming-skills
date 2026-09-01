import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int topAsteroid = stack.peek();
                int currentAsteroidAbs = Math.abs(asteroid);
                int topAsteroidAbs = Math.abs(topAsteroid);

                if (currentAsteroidAbs > topAsteroidAbs) {
                    
                    stack.pop();
                    
                } else if (currentAsteroidAbs == topAsteroidAbs) {
                    
                    stack.pop();
                    asteroid = 0;
                    break; 
                } else {
                    
                    asteroid = 0;
                    break; 
                }
            }
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
