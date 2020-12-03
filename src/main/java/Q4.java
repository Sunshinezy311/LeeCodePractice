public class Q4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        if (nums1.length == 0) {
            if (nums2.length == 1) {
                return nums2[0];
            }
            return getMiddleValue(nums2);
        }
        if (nums2.length == 0) {
            if (nums1.length == 1) {
                return nums1[0];
            }
            return getMiddleValue(nums1);
        }
        int[] all = new int[nums1.length + nums2.length];
        while (i + j + 1 < nums1.length + nums2.length) {
            if (nums1[i] <= nums2[j]) {
                all[i + j] = nums1[i];
                i++;
            } else {
                all[i + j] = nums2[j];
                j++;
            }

            if (i == nums1.length) {
                while (j < nums2.length) {
                    all[i + j] = nums2[j];
                    j++;
                }
            }
            if (j == nums2.length) {
                while (i < nums1.length) {
                    all[i + j] = nums1[i];
                    i++;
                }
            }
        }
        return getMiddleValue(all);
    }

    public static double getMiddleValue(int[] res) {
        if (res.length % 2 == 1) {
            return res[(res.length - 1) / 2];
        } else {
            int index = res.length / 2;
            return ((double) res[index] + (double) res[index - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 5}, new int[]{2, 4}));
    }
}
