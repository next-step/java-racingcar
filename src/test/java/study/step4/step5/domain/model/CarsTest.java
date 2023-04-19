package study.step4.step5.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.step5.domain.model.Car;
import study.step5.domain.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    public void createCars() {
        cars = Cars.from("coby, cobi");
    }

    @Test
    public void 자동차_우승자확인() {
        //given
        cars.startRacing();
        //when
        int winnerPosition = cars.getWinnerPosition();
        List<Car> winners = cars.getWinners();
        //then
        assertThat(winners.get(0).getPosition()).isEqualTo(winnerPosition);
    }
}

