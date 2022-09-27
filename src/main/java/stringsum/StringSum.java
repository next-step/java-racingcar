package stringsum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {

    public String customChar(String testData) {
        if (testData == null || testData.isBlank()) {
            return "";
        }
        Pattern pattern = Pattern.compile("[/][/](.*?)[\\n]");
        Matcher matcher = pattern.matcher(testData);
        String result = "";
        if (matcher.find() && matcher.start() == 0) {
            return testData.substring(2, matcher.end() - 1);
        }
        return result;
    }

    public String[] splitStr(String testData) {
        String custom = customChar(testData);
        if (testData == null) {
            return new String[]{""};
        }
        if (custom.isBlank()) {
            return testData.split(",|:");
        }
        if (custom.equals("+")) {
            custom = "\\+|,|:";
            return testData.substring(4).split(custom);
        }
        custom = ",|:|" + customChar(testData);
        return testData.substring(4).split(custom);
    }

    public int customSum(String testData) {
        String[] splitResult = splitStr(testData);
        if (splitResult[0].equals("")) {
            return 0;
        }
        int sum = 0;
        for (String str : splitResult) {
            if (Integer.parseInt(str) < 0) {
                throw new RuntimeException();
            }
            sum += Integer.parseInt(str);
        }
        return sum;
    }
}
