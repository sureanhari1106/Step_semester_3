import java.util.Arrays;

public class productExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int product = 1;

        // Forward pass: product of elements on the left
        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product *= nums[i];
        }

        product = 1;

        // Backward pass: multiply by elements on the right
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            productExceptSelf(new int[]{1, 2, 3, 4})
        ));

        System.out.println(Arrays.toString(
            productExceptSelf(new int[]{-1, 1, 0, -3, 3})
        ));
    }
}
