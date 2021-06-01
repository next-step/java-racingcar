package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        this.car = new Car();
        car.add("현진");
        car.add("진현");
    }

    @DisplayName("자동차는 이름을 가진다.")
    @Test
    public void addTest() {
        assertThat(car.getCars().get(0).getName()).isEqualTo("현진");
    }

    @DisplayName("자동차는 무작위 값이 4이상일 때 움직일 수 있다.")
    @Test
    public void moveTest() {
        car.getCars().get(0).move(true);
        car.getCars().get(0).move(true);
        car.getCars().get(0).move(false);

        assertThat(car.getCars().get(0).getLocationInfo()).isEqualTo(2);
    }

    @DisplayName("우승자를 알 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = 2)
    public void compareWinnerTest(int winnerScore) {
        car.getCars().get(0).move(true);
        car.getCars().get(0).move(true);
        car.getCars().get(0).move(false);

        assertAll(
                () -> assertThat(car.getCars().get(0).compareWinnerScore(winnerScore)).isTrue(),
                () -> assertThat(car.getCars().get(1).compareWinnerScore(winnerScore)).isFalse()
        );
    }
}
