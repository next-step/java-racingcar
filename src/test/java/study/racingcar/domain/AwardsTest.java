package study.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.racingcar.strategy.MaxPositionWinnerStrategy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-22
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class AwardsTest {
    private Awards awards;
    private CarsRacingLog carsRacingLog;

    @BeforeEach
    void setUp() {
        this.awards = new Awards(new MaxPositionWinnerStrategy());
        this.carsRacingLog = new CarsRacingLog();
    }

    @Test
    void 우승차_한대() {
        CarRacingLog winner1 = new CarRacingLog(new Car("car3"), 3);

        carsRacingLog.add(new CarRacingLog(new Car("car1"), 1));
        carsRacingLog.add(new CarRacingLog(new Car("car2"), 2));
        carsRacingLog.add(winner1);

        Cars winners = awards.award(carsRacingLog);

        assertThat(winners.getCars()).containsExactly(winner1.getCar());
    }

    @Test
    void 우승차_두대() {
        CarRacingLog winner1 = new CarRacingLog(new Car("car3"), 3);
        CarRacingLog winner2 = new CarRacingLog(new Car("car4"), 3);

        carsRacingLog.add(new CarRacingLog(new Car("car1"), 1));
        carsRacingLog.add(new CarRacingLog(new Car("car2"), 2));
        carsRacingLog.add(winner1);
        carsRacingLog.add(winner2);

        Cars winners = awards.award(carsRacingLog);

        assertThat(winners.getCars()).containsExactly(winner1.getCar(), winner2.getCar());
    }
}
