package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputValueTest {

    @DisplayName("값이 같을경우 동일성 여부")
    @ParameterizedTest(name = "자동차 숫자: {0} 시도횟수 : {1}")
    @CsvSource(value = {
            "3 | 4",
            "6 | 2",
            "3 | 6"
    }, delimiter = '|')
    void createInputValue(int numberOfCars, int numberOfAttempts) {
        InputValue inputValue1 = InputValue.create(numberOfCars, numberOfAttempts);
        InputValue inputValue2 = InputValue.create(numberOfCars, numberOfAttempts);
        assertThat(inputValue1).isEqualTo(inputValue2);
    }

    @DisplayName("입력값 객체 생성후 목적에 맞는 값 반환")
    @ParameterizedTest(name = "자동차 숫자: {0} 시도횟수 : {1}")
    @CsvSource(value = {
            "3 | 4",
            "6 | 2",
            "3 | 6"
    }, delimiter = '|')
    void returnCarsAndAttempts(int numberOfCars, int numberOfAttempts) {
        InputValue inputValue = InputValue.create(numberOfCars, numberOfAttempts);
        assertAll(
                () -> assertThat(inputValue.attempts()).isEqualTo(numberOfAttempts),
                () -> assertThat(inputValue.cars()).isEqualTo(numberOfCars)
        );
    }

}