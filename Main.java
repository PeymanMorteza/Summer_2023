import java.util.HashMap;
import java.util.Random;

public class Main{
	public static int[] generateRandomArray(int length, int minValue, int maxValue) {
        	int[] array = new int[length];
        	Random random = new Random();

        	for (int i = 0; i < length; i++) {
            		array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        	}

        return array;
    	}
	public static boolean hashTwoSum(int [] nums, int target){
		HashMap<Integer,Integer> hashMap= new HashMap<>();
		//(key,value)
		for (int i=0;i<nums.length;i++){
			int complement=target-nums[i];
			if (hashMap.containsKey(complement)){
				return true;
			}
			hashMap.put(nums[i],i);	
		}
		return false;
	}
	public static boolean naiveTwoSum(int [] nums, int target){
		for (int i=0;i<nums.length;i++){
			for (int j=i+1;j<nums.length;j++){
				if (nums[i]+nums[j]==target){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args){
		//System.out.println("Hello!");
		//int [] myArray={2,5,7,9};
		//System.out.println("Naive Two Sum");
		//System.out.println(naiveTwoSum(myArray,10));

		//System.out.println(naiveTwoSum(myArray,7));

		//System.out.println(naiveTwoSum(myArray,14));
		
		//System.out.println(naiveTwoSum(myArray,16));
		//System.out.println("Hash Two Sum");
		//System.out.println(hashTwoSum(myArray,10));

		//System.out.println(hashTwoSum(myArray,7));

		//System.out.println(hashTwoSum(myArray,14));
		
		//System.out.println(hashTwoSum(myArray,16));
		int arrayLength=200000;
		int minValue=0;
		int maxValue=100;			
		int[] randomArray = generateRandomArray(arrayLength, minValue, maxValue);			
		long startTimeMillis = System.currentTimeMillis();
		boolean hashResult=hashTwoSum(randomArray,1000);
		long endTimeMillis = System.currentTimeMillis();
		System.out.println(String.format("Hash Two Sum time is %d milli-seconds and result is %b",(endTimeMillis- startTimeMillis),hashResult));
		startTimeMillis = System.currentTimeMillis();
		boolean naiveResult=naiveTwoSum(randomArray,1000);
		endTimeMillis = System.currentTimeMillis();
		System.out.println(String.format("Naive Two Sum time is %d milli-seconds and result is %b",(endTimeMillis- startTimeMillis),naiveResult));

	}
}
