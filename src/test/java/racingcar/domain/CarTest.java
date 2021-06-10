package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    private Cars cars;

    @BeforeEach
    public void setUp() {
        this.cars = new Cars();
        cars.addCars("현진");
        cars.addCars("진현");
    }

    @DisplayName("자동차는 이름을 가진다.")
    @Test
    public void addTest() {
        assertThat(cars.getCars().get(0).getName()).isEqualTo("현진");
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"jeonggggg,hyeon,jin"})
    public void splitString(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Car(input));
    }

    @DisplayName("자동차는 무작위 값이 4이상일 때 움직일 수 있다.")
    @Test
    public void moveTest() {
        cars.getCars().get(0).move(true);
        cars.getCars().get(0).move(true);
        cars.getCars().get(0).move(false);

        assertThat(cars.getCars().get(0).getLocation()).isEqualTo(2);
    }

    @DisplayName("우승자를 알 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = 2)
    public void compareWinnerTest(int winnerScore) {
        cars.getCars().get(0).move(true);
        cars.getCars().get(0).move(true);
        cars.getCars().get(0).move(false);

        assertAll(
                () -> assertThat(cars.getCars().get(0).isWinner(winnerScore)).isTrue(),
                () -> assertThat(cars.getCars().get(1).isWinner(winnerScore)).isFalse()
        );
    }
}
