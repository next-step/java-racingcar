package step2;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {


    public int calculate(String expression){
        if(expression == null || expression.isEmpty()){
            return 0;
        }

        return Arrays.stream(expression.split("[,|:]"))
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
