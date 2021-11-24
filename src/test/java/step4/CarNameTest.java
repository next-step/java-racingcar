package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.dto.CarName;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobyconan", "kero1004", "reviewer", "nextstep"})
    @DisplayName("1~5자가 아닌 자동차 이름을 받으면 예외를 던진다")
    public void nameException(String name) {

        Assertions.assertThatThrownBy(() -> {
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"poby", "kero", "next", "step"})
    @DisplayName("정상적인 자동차 이름을 받으면 자동차 이름 객체가 생성된다.")
    public void nameSuccess(String name) {
        CarName carName = new CarName(name);

        Assertions.assertThat(carName).isNotNull();
    }
}
