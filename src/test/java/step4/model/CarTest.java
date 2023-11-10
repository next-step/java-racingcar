package step4.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"차차차차차차", "TTTTTTT", "포르쉐쉐쉐쉐쉐쉐", "랜드로바바바바바바"})
    void 자동차는_이름을_5자_초과해서_가질면_예외를_발생한다(String carName) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(carName);
                }).withMessageMatching("자동차 이름은 \\d+자를 초과할 수 없습니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"차", "TT", "포르쉐", "랜드로바", "람보르기니"})
    @DisplayName("5자 미만의 이름을 가진 자동차는 정상 생성된다.")
    void 자동차는_5자_미만의_이름을_가지면_생성된다(String carName) {
        Assertions.assertThat(new Car(carName).getName()).isEqualTo(carName);
    }

}