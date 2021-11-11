package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.vo.InputValue;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputValueTest {

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>();
        carNames.add("자동차 이름1");
        carNames.add("자동차 이름2");
        carNames.add("자동차 이름3");
        carNames.add("자동차 이름4");
    }

    @DisplayName("값이 같을경우 동일성 여부")
    @ParameterizedTest(name = "시도횟수 : {0}일때")
    @ValueSource(ints = {3, 4, 5, 6})
    void createInputValue(int numberOfAttempts) {
        InputValue inputValue1 = InputValue.create(carNames, numberOfAttempts);
        InputValue inputValue2 = InputValue.create(carNames, numberOfAttempts);
        assertThat(inputValue1).isEqualTo(inputValue2);
    }

    @DisplayName("입력값 객체 생성후 목적에 맞는 값 반환")
    @ParameterizedTest(name = "시도횟수 : {0}일때")
    @ValueSource(ints = {3, 4, 5, 6})
    void returnCarsAndAttempts(int numberOfAttempts) {
        InputValue inputValue = InputValue.create(carNames, numberOfAttempts);
        assertAll(
                () -> assertThat(inputValue.attempts())
                        .isEqualTo(numberOfAttempts),
                () -> assertThat(inputValue.cars())
                        .isEqualTo(carNames.size()),
                () -> assertThat(inputValue.carNames()
                        .containsAll(carNames))
                        .isTrue()
        );
    }

}