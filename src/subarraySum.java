import java.util.HashMap;
import java.util.Map;

public class subarraySum {

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();

        // Empty prefix has sum zero
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            int required = prefixSum - k;

            count += prefixCount.getOrDefault(required, 0);

            prefixCount.put(
                prefixSum,
                prefixCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(
            subarraySum(new int[]{1, 1, 1}, 2)
        );

        System.out.println(
            subarraySum(new int[]{1, -1, 0}, 0)
        );
    }
}
