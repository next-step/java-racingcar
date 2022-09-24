package stringsum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {

    public String[] basicSplitStr(String testData){
        return testData.split(",|:");
    }

    public int basicSum(String testData){
        String[] splitResult = testData.split(",|:");
        int sum = 0;
        for(String td : splitResult){
            sum += Integer.parseInt(td);
        }
        return sum;
    }

    public String customChar(String testData){
        Pattern pattern = Pattern.compile("[/][/](.*?)[\\n]");
        Matcher matcher = pattern.matcher(testData);
        String result = null;
        if(matcher.find() && matcher.start() == 0){
            return testData.substring(2, matcher.end()-1); // 특정 단어 사이의 값 추출
        }
        return result;
    }

    public String[] splitStr(String testData){
        String custom = customChar(testData);
        if(custom.equals("+")){
            custom = "\\+|,|:";
            return testData.substring(4).split(custom);
        }
        custom = ",|:|" + customChar(testData);
        return testData.substring(4).split(custom);
    }

    public int calculator(){
        String[] splitResult = basicSplitStr("1:2:3,5,7,6,d");
        int sum = 0;
        for(String td : splitResult){
            sum += Integer.parseInt(td);
        }
        return sum;
    }
}
