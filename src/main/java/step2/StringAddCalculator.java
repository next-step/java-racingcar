package step2;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static String DEFAULT_DELIMITER = ",";
    private static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public Number splitAndSum(String text) {

        List<Number> numberList =  split(text);

        Numbers numbers = new Numbers(numberList);

        return numbers.sum();
    }

    public List<Number> split(String text) {
        if(text == null || text.isBlank()){
            return Collections.emptyList();
        }


        Matcher m = pattern.matcher(text);
        if(m.find()){
            String delimiter = m.group(1);
            String[] values = m.group(2).split(delimiter+"|"+DEFAULT_DELIMITER);
            return StringsToNumbers(values);
        }


        return StringsToNumbers(text.split(DEFAULT_DELIMITER));
    }

    public List<Number> StringsToNumbers(String[] arr){
        return Arrays.stream(arr)
                .map(n->new Number(Integer.parseInt(n)))
                .collect(Collectors.toList());
    }


}
