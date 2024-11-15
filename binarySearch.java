public class binarySearch {


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,5,5,5,6,7};
                           //  {0,1,2,3,4,5,6,7,8,9}
        int index=right_bound(array,5);
        int index2 = left_bounded(array,5);
        System.out.println(index+" "+index2);
        
        
    }

    public static int left_bounded(int[] array, int target){
        if(array.length == 0) return 0;
        int left =0;
        int right= array.length; // [start,end) == [start,end-1]


            while(left < right){
            int mid = left+(right-left)/2;


            if(array[mid] == target ){
                right = mid;

            }
            else if(array[mid] > target){
                right = mid;
            }
            else if(array[mid] < target){
                left = mid+1;
            }
        
        }

        if(left<0 || left>array.length){
            return -1;
        }
        return array[left]==target? left:-1;
    }
     public static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // do not return, lock the right boundary
                left = mid + 1;
            }
        }
        // since the while loop ends with right == left - 1 and we are now looking for the right boundary
        // it's easier to remember to use right instead of left - 1
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }
    
}
