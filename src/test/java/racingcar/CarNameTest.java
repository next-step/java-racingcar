package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 테스트")
    void carNameTest() {
        String name = "hello";
        CarName carName = new CarName(name);
        assertThat(carName).isEqualTo(new CarName(name));
    }

    @Test
    @DisplayName("자동차이름은 5글자를 넘을 수 없습니다.")
    void validateCarNameTest() {
        String EXCEEDS_NUMBER_OF_CAR_NAME_CHARACTERS = "Hello1";
        assertThatThrownBy(() -> new CarName(EXCEEDS_NUMBER_OF_CAR_NAME_CHARACTERS)).isInstanceOf(IllegalArgumentException.class);
    }
}
