import java.util.*;

class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> pair = new HashMap<Integer,Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            Integer freq = pair.get(nums[i]);
            if(freq == null)
                freq=0;
            pair.put(nums[i],freq+1);
        }
        for(int i=0;i<nums.length;i++){
            if(pair.get(nums[i])==1)
                res.add(nums[i]);
        }
        return res.stream().mapToInt(i->i).toArray();
        
    }
}