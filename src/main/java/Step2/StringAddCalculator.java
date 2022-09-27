package Step2;

import java.util.Arrays;

public class StringCalculator {

    public int addStringCalculator(String s){
        int sum =0;
        if(!checkIsNull(s))
            return sum;

        for(int i : getIntegers(s)){
            sum+=i;
        }

        return sum;
    }

    public boolean checkIsNull(String s){
        return (s.isEmpty() || s == null || s.equals(""));
    }

    public int[] getIntegers(String s){
        int [] intAry = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

        return intAry;
    }
}
