package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.dto.CarName;

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

    @ParameterizedTest
    @CsvSource(value = {"step1,step1", "step2,step2", "step3,step3", "step4,step4", "step5,step5"})
    @DisplayName("현재 자동차 이름과 새로운 자동차 이름을 정상적으로 비교한다.")
    public void nameEqualTest(String input, String expected) {
        Assertions.assertThat(new CarName(input)).isEqualTo(new CarName(expected));
    }
}
