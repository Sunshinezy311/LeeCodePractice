import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Q1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        Map<Integer, Integer> lackVal2ValIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index2 = lackVal2ValIndex.get(nums[i]);
            if (index2 != null) {
                res[0] = i;
                res[1] = index2;
                return res;
            }
            lackVal2ValIndex.put(target - nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}