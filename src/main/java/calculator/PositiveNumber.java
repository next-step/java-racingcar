package calculator;

import java.util.List;

public class PositiveNumber {
    public boolean checkNegativeNumber(List<String> numbers){
        String minusSign = "-";
        for (String number : numbers) {
            if (number.contains(minusSign)) {
                return true;
            }
        }
        return false;
    }
}
