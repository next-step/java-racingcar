package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Car;
import step4.model.Name;
import step4.view.validation.ValidationInput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationInputTest {

    @ParameterizedTest
    @ValueSource(ints = {-1,-2,-3})
    @DisplayName("음수 값을 넣는다면 예외가 발생한다.")
    void negativeNumberTest(int cars) {
        assertThatThrownBy(() -> ValidationInput.positiveNumber(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 값을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    @DisplayName("양수 값을 입력한다면 입력한 값을 그대로 리턴한다.")
    void positiveNumberTest(int cars) {
        assertThat(ValidationInput.positiveNumber(cars))
                .isEqualTo(cars);
    }

    @ParameterizedTest
    @ValueSource(strings = {"jane","john"})
    @DisplayName("5글자 이하의 자동차 이름이 들어올 경우 길이 검증에 통과하여 자동차 리스트를 리턴한다.")
    void verifyInputLengthTest(String carNames) {
        assertThat(new Car(new Name(carNames))).isInstanceOf(Car.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"janehahaha", "johnhahaha"})
    @DisplayName("5글자 이상의 자동차 이름이 들어올 경우 예외를 발생시킨다.")
    void verifyInputLengthExceptionTest(String carNames) {
        assertThatThrownBy(() -> new Car(new Name(carNames)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 넘을 수 없습니다.");
    }
}
