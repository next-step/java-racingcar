package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Cal;

public class CalTest {
    @DisplayName("전부쪼개기")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2"})
    void caltests(String input){
        System.out.println(input);
        Cal ca = new Cal();
        String [] splitresult = null;

        splitresult = ca.splitWord(input);
        String [] sachicresult = null;

        sachicresult = ca.calsachicInput(splitresult);
        

    }
}
