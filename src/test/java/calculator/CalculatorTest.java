package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void isBlank() {
        String str = "2 + 3 * 4 / 2";
        String[] splitBlank = str.split(" ");

        Strings.isBlank(str);
        Strings.checkSymbol(splitBlank);
        Opperation.findBySymbol("+");

    }
}