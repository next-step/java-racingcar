package carRacing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:1:2",
            "3:2:3:2",
            "0:3:0:3",
            "3:0:3:0"}, delimiter = ':')
    @DisplayName("사용자 입력값을 제대로 저장할 수 있다")
    public void userInputGeneratesUserInput(int numberOfCars, int numberOfRace,
                                            int expectedNumberOfCars, int expectedNumberOfRace){
        UserInput userInput = new UserInput(numberOfCars, numberOfRace);
        assertEquals(userInput.getNumberOfCars(), expectedNumberOfCars);
        assertEquals(userInput.getNumberOfRace(), expectedNumberOfRace);
    }
}