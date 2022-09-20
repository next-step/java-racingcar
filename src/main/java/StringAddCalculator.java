import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String data) {
        int sum = 0;
        int number = 0;
        String[] patternDataList = null;

        if (data.length() == 1) {
            number = Integer.parseInt(data);
        }else if(data.length() > 0){
            number = dataNullChk(data);
        }

        Matcher pattern = Pattern.compile("//(.)\n(.*)").matcher(data);

        if (pattern.find()) {
            number = dataSum(pattern.group(2), pattern.group(1), sum);
        }

        number = dataSum(data, ",|:", sum);
        return number;
    }

    private int dataSum(String data, String regex, int sum) {
        String[]dataList = data.split(regex);
        for (String sumData : dataList) {
            if (Integer.parseInt(sumData) < 0) {
                throw new RuntimeException("음수가 들어왔습니다");
            } else {
                sum += Integer.parseInt(sumData);
            }
        }
        return sum;
    }

    public int dataNullChk(String data) {
        if (data == null || data.isEmpty()) {
            return 0;
        }else{
            return Integer.parseInt(data);
        }
    }

}
