import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int splitAndSum(String input) {
        if(input == null || input.isEmpty()){
            //값이 없다면 0리턴
            return 0;
        }
        //스플릿
        String[] values = this.split(input);

        return this.sum(values);
    }

    private String[] split(String input) {
        //커스텀 구분자
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            //커스텀 패턴이 있다면 커스텀 구분자로 스플릿
            String delimiter = m.group(1);
            String values = m.group(2);
            return values.split(delimiter);
        }

        //일반 구분자로 값 리턴
        return input.split(",|:");
    }

    private int sum(String[] values) {
        int sum = 0;

        for(String value : values) {
            int intValue = Integer.parseInt(value);

            if(intValue < 0) {
                //음수일경우 RuntimeException 발생
                throw new RuntimeException("음수를 입력할 수 없습니다.");
            }
            sum += intValue;
        }
        return sum;
    }
}
