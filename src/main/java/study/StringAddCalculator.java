package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String value)throws Exception{
        int result = checkNull_Empty(value);
        String[] values;

        if(result == 0){
            return result;
        }else{
            values = checkSeparator(value);
            int calcul = 0;
            for(String val : values){
                calcul += checkNegative(Integer.valueOf(val));
            }
            result = calcul;
        }
        return result;
    }

    public int checkNull_Empty(String value)throws Exception{
        int result = -1;

        if(value == null){
            result = 0;
        }else if(value.isEmpty()){
            result = 0;
        }
        return result;
    }

    public String[] checkSeparator(String value) throws Exception{

        String[] number;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);

        if(m.find()){
            String customDelimiter = m.group(1);
            number = m.group(2).split(customDelimiter);
        }else{
            number = value.split(",|:");
        }
        return number;
    }

    public int checkNegative(int value) throws Exception{
            if(0 > value){
                throw new RuntimeException();
            }
            return value;
    }

}
