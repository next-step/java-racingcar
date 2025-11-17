package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarWinnerTest {

    @Test
    @DisplayName("자동차 이름을 부여할 수 있다")
    void assignCarNames() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름은 빈 문자열이나 null이 될 수 없다")
    void carNameCannotBeNullOrEmpty(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "longcarname", "123456"})
    @DisplayName("각 자동차의 이름은 5자를 초과할 수 없다")
    void carNameCannotExceedFiveCharacters(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux", "pobi"})
    @DisplayName("각 자동차의 이름은 중복될 수 없다")
    void carNamesCannotBeDuplicated(String name) {
        Racing racing = new Racing(4);

        assertThatThrownBy(() -> racing.addCar(new Car(name))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름은 쉼표(,)를 기준으로 구분한다")
    void carNamesAreSeparatedByComma() {
        String input = "pobi,crong,honux";
        String[] names = input.split(",");

        assertThat(names).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("우승자는 가장 멀리 간 자동차이다")
    void winnerIsFurthestCar() {

    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 모두 출력한다")
    void multipleWinnersAreAllAnnounced() {

    }

}
