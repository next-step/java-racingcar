package racing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.Ranking;

public class WinnerTest {

    private RacingCars racingCars;

    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new ArrayList<>();
    }

    @Test
    @DisplayName("우승자가 한 명일 경우 우승자 출력 테스트")
    public void oneWinnerTest() {
        Car pobi = new Car("pobi", 2);
        Car javajigi = new Car("javajigi", 2);
        Car crong = new Car("crong", 3);

        cars.add(pobi);
        cars.add(javajigi);
        cars.add(crong);

        assertThat(Ranking.findWinners(cars)).containsExactly("crong");
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 우승자 출력 테스트")
    public void manyWinnerTest() {
        Car pobi = new Car("pobi", 2);
        Car javajigi = new Car("javajigi", 3);
        Car crong = new Car("crong", 3);

        cars.add(pobi);
        cars.add(javajigi);
        cars.add(crong);

        racingCars = new RacingCars(cars);
        assertThat(Ranking.findWinners(cars)).containsExactly("javajigi", "crong");
    }
}
