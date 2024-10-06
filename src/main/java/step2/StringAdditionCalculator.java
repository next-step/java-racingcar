package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {

    private static final String ADDITION_SEPERATOR = ",:";
    private static final Pattern EXTRACT_PATTERN = Pattern.compile("//(.*?)\\n");
    private static final Pattern COMPILED_PATTERN = Pattern.compile("^[0-9" + ADDITION_SEPERATOR+ "]+$");;

    public StringAdditionCalculator(){};

    public Long calculate(String input){

        if(input == null || input.isEmpty())
            return 0L;

        input = replaceCustomSeperator(input);
        checkInputPattern(input);
        return additionArray(getNumberArray(input));

    }

    public String replaceCustomSeperator(String input){

        Matcher matcher = EXTRACT_PATTERN.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String replaceRegex = "["+delimiter+"]";

            input = input.replaceAll("//(.*?)\\n", "");
            input = input.replaceAll(replaceRegex, ":");
        }

        return input;
    }

    public void checkInputPattern(String input){

        Matcher matcher = COMPILED_PATTERN.matcher(input);

        if (!matcher.matches())
            throw new RuntimeException("옳지 않은 패턴 또는 음수가 포함되어 있습니다.");

    }

    public Long[] getNumberArray(String input) {
        String[] stringArray = input.split("[" + ADDITION_SEPERATOR + "]+");

         return Arrays.stream(stringArray)
                .map(Long::parseLong)
                .toArray(Long[]::new);
    }

    public Long additionArray(Long[] numberArray){
        Long result = 0L;

        for(Long number : numberArray) {
            result+=number;
        }

        return result;
    }
}
