package stringsum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {
    // 요구사항1
    // 쉼표(,) 콜론(:)으로 구분하기
    public String[] basicSplitStr(String testData){
        return testData.split(",|:");
    }

    // 합 반환하기
    public int basicSum(){
        String[] splitResult = basicSplitStr("1:2:3,5,7,6");
        int sum = 0;
        for(String td : splitResult){
            sum += Integer.parseInt(td);
        }
        return sum;
    }

    //요구사항2
    // //문자와 줄바꿈 사이 값 확인
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

    // 요구사항3
    // 예외발생
    public int calculator(){
        String[] splitResult = basicSplitStr("1:2:3,5,7,6,d");
        int sum = 0;
        for(String td : splitResult){
            sum += Integer.parseInt(td);
        }
        return sum;
    }
}
