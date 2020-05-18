package study.step2_1;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator{
    private final static String DELIMITER =" ";
    private final static String NUMBERPATTERN = "^[0-9]+$";
    private final static Pattern PATTERN_COMPILE = Pattern.compile(NUMBERPATTERN);

    private String [] separateByDelimiter(String expression){
        isBlank(expression);
        return expression.split(DELIMITER);
    }

    private boolean isBlank(String input){
        if (Objects.isNull(input)  || input.trim().isEmpty()){
            throw new IllegalArgumentException("값이 비어있습니다.");
        }
        return false;
    }

    private static boolean isNumber(String value) {
        if (!Objects.isNull(value)){
            return PATTERN_COMPILE.matcher(value).find();
        }
        return false;
    }

    private static List<Double> separateNumber(String[] values) {
        return Arrays.stream(values)
                .filter(value -> isNumber(value))
                .map(value -> Double.parseDouble(value))
                .collect(Collectors.toList());
    }

    private static List<String> separateOperator(String[] values) {
        return Arrays.stream(values)
                .filter(value -> Operator.isOperator(value))
                .collect(Collectors.toList());
    }
=======
public class StringCalculator{
>>>>>>> d1896fdcab2eb83ee20138f031ab12d323e07844

    public double calculate(String expression) {

        // 1. 문자열 분리
        String [] values = separateByDelimiter(expression);

        // 2. 분리된 문자열 중 연산자 , 피연산자 구분
        List<Double> separateNumbers = separateNumber(values);
        List<String> separateOperators = separateOperator(values);

        Calculation calculation = new Calculation(values, separateNumbers, separateOperators);

        // 3. 연산(계산)
        return  calculation.calculate();
    }

}