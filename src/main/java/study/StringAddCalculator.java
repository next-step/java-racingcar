package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SPLIT_CHAR = ",|:";
    private static final String CUSTOM_PATTERN = "//(.)\\n(.*)";

    public static int splitAndSum(String str){
        int result = 0;
        if(str == null || str.isEmpty()){
            return 0;
        } else {
            Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(str);
            if (m.find()) {
                String customDelimiter = m.group(1);
                String[] tokens= m.group(2).split(customDelimiter);
                return sum(tokens);
            }

            String[] nums = str.split(SPLIT_CHAR);
            result = sum(nums);
        }
        return result;
    }

    public static int sum(String[] nums){
        int result = 0;
        for(int i = 0; i< nums.length ; i++){
            int num = Integer.parseInt(nums[i]);
            if (num < 0 ){
                throw new RuntimeException("Only Positive Integer!");
            }
            result += num;
        }
        return result;
    }
}
