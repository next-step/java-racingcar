package step2;

import static java.lang.Integer.parseInt;

public class StringAdditionCalculator {
    public boolean checkNullOrEmpty(String text) {
        if(text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
