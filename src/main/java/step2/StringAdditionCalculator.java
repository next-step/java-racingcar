package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {

    private Long[] numberArray;
    private Long result;
    private String customSeperator = "";
    private String additionSeperator = ",:";

    public StringAdditionCalculator(){};

    public Long calculate(String input){

        if(input == null || input.isEmpty())
            return 0L;

        input = extractCustomSeperator(input);
        checkInputPattern(input);
        setNumberArray(input);
        additionArray();

        return result;
    }

    public String extractCustomSeperator(String input){

        String regex = "//(.*?)\\n";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            customSeperator += delimiter;
        }

        return input.replaceAll(regex, "");
    }

    public void checkInputPattern(String input){

        Pattern compiledPattern = Pattern.compile("^[0-9" + additionSeperator + customSeperator + "]+$");
        Matcher matcher = compiledPattern.matcher(input);

        if (!matcher.matches())
            throw new RuntimeException();
        
    }

    public void setNumberArray(String input) {
        String[] stringArray = input.split("[" + additionSeperator + customSeperator + "]+");

        numberArray = Arrays.stream(stringArray)
                .map(Long::parseLong)
                .toArray(Long[]::new);
    }

    public void additionArray(){
        result = 0L;

        for(Long number : numberArray) {
            result+=number;
        }
    }
}
