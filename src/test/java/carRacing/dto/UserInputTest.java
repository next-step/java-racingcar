package carRacing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputTest {

    @ParameterizedTest
    @CsvSource(value = {
            "pobi,crong,honux:3:3"}, delimiter = ':')
    @DisplayName("사용자 입력값을 제대로 저장할 수 있다")
    void userInputGeneratesUserInput(String unparsedNames, int numberOfRace, int expectedNumberOfRace) {
        UserInput userInput = new UserInput(unparsedNames, numberOfRace);
        assertThat(userInput.getNumberOfRace()).isEqualTo(expectedNumberOfRace);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "pobiee,crong,honux:2",
            "pobi,crongee:2",
            "pobi,crong,honux,pororo:3"}, delimiter = ':')
    @DisplayName("범위에 맞지 않는 문자열 인덱스의 값을 구할 경우 에러를 던짐")
    void invalidInputThrowsIllegalArgumentException(String unparsedNameOfCars, int numberOfRace) {
        assertThrows(IllegalArgumentException.class,
                () -> new UserInput(unparsedNameOfCars, numberOfRace));
    }

}