import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    public int splitAndSum(String input) {
        if(input == null || input.isEmpty()){
            //값이 없다면 0리턴
            return 0;
        }
        //스플릿
        String[] values = this.split(input);

        return this.sum(parsingInts(values));
    }

    private String[] split(String input) {
        //커스텀 구분자
        Matcher m = CUSTOM_PATTERN.matcher(input);

        if (m.find()) {
            //커스텀 패턴이 있다면 커스텀 구분자로 스플릿
            String customDelimiter = m.group(1);
            String values = m.group(2);
            return values.split(customDelimiter);
        }

        //일반 구분자로 값 리턴
        return input.split(DEFAULT_DELIMITER);
    }

    private int sum(int[] intValues) {
        int sum = 0;

        for (int intValue : intValues) {
            sum += intValue;
        }

        return sum;
    }

    private int[] parsingInts(String[] values) {
        int[] ints = new int[values.length];

        for(int index = 0; index < values.length; index++) {
            int intValue = Integer.parseInt(values[index]);

            if(intValue < 0) {
                //음수일경우 RuntimeException 발생
                throw new RuntimeException("음수를 입력할 수 없습니다.");
            }
            ints[index] = intValue;
        }
        return ints;
    }

}
