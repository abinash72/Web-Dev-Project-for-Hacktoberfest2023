import java.util.*;

public class StockSpanProblem {
    public static int[] calculateSpan(int[] prices) {
        int[] spans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        // Process the first element
        stack.push(0);
        spans[0] = 1;
        
        // Process the rest of the elements
        for (int i = 1; i < prices.length; i++) {
            // Pop elements from the stack as long as the price at the current index is greater than the price at the top of the stack
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            
            // Calculate the span for the current element
            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return spans;
    }
    
    public static void main(String[] args) {
        int[] prices = {100, 20, 30, 20, 70, 75, 85};
        int[] spans = calculateSpan(prices);
        
        System.out.println("Stock Span Values:");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
