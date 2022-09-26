package stringsum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {

    public int basicSum(String testData) {
        if (testData == null || testData.isBlank() || testData.trim().isEmpty()) {
            return 0;
        }
        String[] splitResult = testData.split(",|:");
        int sum = 0;
        for (String td : splitResult) {
            sum += Integer.parseInt(td);
        }
        return sum;
    }

    public String customChar(String testData) {
        if (testData == null || testData.isBlank() || testData.trim().isEmpty()) {
            return "";
        }
        Pattern pattern = Pattern.compile("[/][/](.*?)[\\n]");
        Matcher matcher = pattern.matcher(testData);
        String result = "";
        if (matcher.find() && matcher.start() == 0) {
            return testData.substring(2, matcher.end() - 1); // 특정 단어 사이의 값 추출
        }
        return result;
    }

    public String[] splitStr(String testData) {
        String custom = customChar(testData);
        if (custom == "" || custom.isBlank() || custom.trim().isEmpty()) {
            return custom.split(",|:");
        } else if (custom.equals("+")) {
            custom = "\\+|,|:";
            return testData.substring(4).split(custom);
        }
        custom = ",|:|" + customChar(testData);
        return testData.substring(4).split(custom);
    }

    public int customSum(String testData) {
        String[] splitResult = splitStr(testData);
        if (splitResult[0] == "") {
            return 0;
        }
        int sum = 0;
        for (String str : splitResult) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }

    public int calculator() {
        String[] splitResult = splitStr("1:2:3,5,7,6,d");
        int sum = 0;
        for (String td : splitResult) {
            sum += Integer.parseInt(td);
        }
        return sum;
    }
}
