package Step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static String delimeters = ",|:";
    public static Pattern pattern = Pattern.compile("//(.*)\n(.*)");

    public static int splitAndSum(String s){
        int sum =0;

        if(checkIsNull(s) || checkIsBlank(s))
            return sum;

        //Custom delimeter가 있다면
        if(pattern.matcher(s).matches()){
            addCustomDelimeters(s);
            s=removeCustomDelimeter(s);
        }
        for(String i : getIntegers(s)){
            sum+=Integer.parseInt(i);
        }
        return sum;
    }

    public static String[] getIntegers(String s){
        if(s.contains("-"))
            throw new RuntimeException("음수 Runtime Exception");
        return s.split(delimeters);
    }

    public static String removeCustomDelimeter(String s){
        Matcher matcher = pattern.matcher(s);
        String removedDeliStr="";
        if(matcher.find()){
            removedDeliStr = matcher.group(2);
        }
        return removedDeliStr;
    }

    public static void addCustomDelimeters(String s){
        Matcher m = pattern.matcher(s);
        //group()함수를 쓰려면, find() 메소드를 사용해야 커서가 이동하므로 반드시 꼭 써준다
        if(m.find()){
            for(char c:m.group(1).toCharArray()){
                delimeters+=("|"+c);
            }
        }
    }

    public static boolean checkIsNull(String s){
        return (s == null);
    }
    public static boolean checkIsBlank(String s){
        return (s.isEmpty()  || s.equals(""));
    }


}
