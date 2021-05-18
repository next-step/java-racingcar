package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingTest {
    @DisplayName("레이싱 테스트")
    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun"})
    void racingtests(String input){
        System.out.println(input);

    }
}
