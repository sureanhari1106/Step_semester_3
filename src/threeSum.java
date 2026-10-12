import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);

        List<int[]> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{
                        nums[i], nums[left], nums[right]
                    });

                    left++;
                    right--;

                    // Skip duplicate values
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] result = threeSum(
            new int[]{-1, 0, 1, 2, -1, -4}
        );

        System.out.println(Arrays.deepToString(result));

        int[][] result2 = threeSum(new int[]{0, 0, 0});

        System.out.println(Arrays.deepToString(result2));
    }
}
