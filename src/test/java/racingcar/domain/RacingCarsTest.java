package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {

    @Test
    @DisplayName("우승자 찾기 테스트")
    void winner() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 2);
        Car honux = new Car("honux", 1);
        List<Car> cars = Arrays.asList(pobi, crong, honux);

        RacingCars racingCars = new RacingCars(cars, new MoveRandomStrategy());

        List<String> winners = racingCars.getWinner();

        assertThat(winners).hasSize(1);
        assertThat(winners).contains(pobi.getName());
    }

    @Test
    @DisplayName("이동 테스트")
    void move() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 2);
        Car honux = new Car("honux", 1);
        List<Car> cars = Arrays.asList(pobi, crong, honux);

        RacingCars racingCars = new RacingCars(cars, new MoveRandomStrategy(){
            @Override
            public boolean goOrStop() {
                return true;
            }
        });
        racingCars.move();

        assertThat(racingCars.getCars()).containsExactly(new Car("pobi", 4)
                , new Car("crong", 3), new Car("honux", 2));
    }

}
