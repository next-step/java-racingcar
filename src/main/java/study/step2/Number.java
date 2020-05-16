package study.step2;

import study.step2.common.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Number {

    private List<Integer> numbers;

    public Number(String [] seperateNumberAndOperator) {
        numbers = convertToIntegerList(seperateNumberAndOperator);
    }

    private List<Integer> convertToIntegerList(String[] seperateNumberAndOperator) {

        return Arrays.stream(seperateNumberAndOperator)
                .filter(value -> numberCheck(value))
                .map(value->Integer.parseInt(value))
                .collect(Collectors.toList()); //컬렉션화(?)
    }

    public boolean numberCheck(String value) {
        return StringUtil.isNumber(value);
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
