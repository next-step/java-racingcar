package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    private String name;
    private String winner;
    private Cars cars;

    @BeforeEach
    public void set() {
        name = "a,b,c";
        winner = "b";
        cars = new Cars(name.split(","));
    }

    @DisplayName("Cars의 객체를 생성한다.")
    @Test
    public void carsTest() {
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @DisplayName("우승자를 선별한다.")
    @Test
    public void selectWinnersTest() {
        cars.getCars().get(0).move(true);
        cars.getCars().get(1).move(true);
        cars.getCars().get(1).move(true);

        List<Car> actualWinners = cars.selectWinners();
        assertThat(actualWinners.get(0).getName()).isEqualTo(winner);
    }
}
