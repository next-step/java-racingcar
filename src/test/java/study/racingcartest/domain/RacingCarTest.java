package study.racingcartest.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import racingcar.domain.RacingCar;
import racingcar.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RacingCarTest {
    RacingCar racing;

    @BeforeEach
    void setUp() {
        racing = new RacingCar();
    }

    @Test
    @DisplayName("제일 멀리 간 이동거리 구하기")
    void getMaxPosition(){

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("cyan", 30));
        cars.add(new Car("vince", 100));
        cars.add(new Car("lucas", 20));

        assertEquals(100, racing.getMaxPosition(cars));
    }

    @Test
    @DisplayName("우승자 구하기")
    void judgeWinner(){

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("cyan", 150));
        cars.add(new Car("vince", 100));
        cars.add(new Car("lucas", 20));

        assertThat("[cyan]").isEqualTo(racing.judgeWinner(cars));
    }

}
