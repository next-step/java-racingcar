package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void carNamesTest() {
        CarNames carNames = CarNames.createCarNames("test1,test2,test3");

        assertThat(carNames.numberOfCars()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상일 경우 에러")
    void nameLengthErrorTest() {
        assertThatThrownBy(() -> CarNames.createCarNames("over55,test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 null이거나 공백일 경우 에러")
    void nullOrEmptyTest(String input) {
        assertThatThrownBy(() -> CarNames.createCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름에 콤마만 있을 경우 에러")
    void justCommaTest() {
        assertThatThrownBy(() -> CarNames.createCarNames(","))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 같을 경우 에러")
    void sameNameError() {
        assertThatThrownBy(() -> CarNames.createCarNames("test1,test2,test1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 매치 테스트")
    void carNameMatchTest() {
        CarNames carNames = CarNames.createCarNames("test1,test2,test3");

        Car carOne = carNames.matchCarName(0);
        Car carTwo = carNames.matchCarName(1);
        Car carThree = carNames.matchCarName(2);

        assertThat(carOne)
                .usingRecursiveComparison()
                .isEqualTo(new Car("test1"));

        assertThat(carTwo)
                .usingRecursiveComparison()
                .isEqualTo(new Car("test2"));

        assertThat(carThree)
                .usingRecursiveComparison()
                .isEqualTo(new Car("test3"));
    }

}