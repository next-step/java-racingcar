package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 이름 규칙에 대한 테스트")
public class CarNameTest {

    @Test
    @DisplayName("자동차 이름이 null 이면 NullPointerException 이 발생한다.")
    void carNameNullTest() {
        Assertions.assertThatThrownBy(() -> CarName.from(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("자동차 이름이 빈 값이면 IllegalArgumentException 이 발생한다.")
    void carNameBlankTest() {
        Assertions.assertThatThrownBy(() -> CarName.from(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException 이 발생한다.")
    void carNameLengthTest() {
        Assertions.assertThatThrownBy(() -> CarName.from("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 글자수는 5자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("같은 name값을 가진 carName 객체는 equals가 true이다")
    void equalsTest() {
        CarName carName1 = CarName.from("hello");
        CarName carName2 = CarName.from("hello");
        assertThat(carName1).isEqualTo(carName2);
    }

    @Test
    @DisplayName("같은 name값을 가진 carName 객체는 hashCode가 true이다")
    void hashCodeTest() {
        CarName carName1 = CarName.from("hello");
        CarName carName2 = CarName.from("hello");
        assertThat(carName1.hashCode()).isEqualTo(carName2.hashCode());
    }
}
