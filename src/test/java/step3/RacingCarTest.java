package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static step3.InputView.inputCountCar;
import static step3.InputView.inputTryCount;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    private Race race;

    @BeforeEach
    void setRace() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car());
        carList.add(new Car());
        race = new Race(carList, 5);
    }

    @Test
    public void 자동차_생성() {
        assertThat(race.getCarList()).hasSize(2);
    }

    @Test
    public void 시도횟수_입력() {
        assertThat(race.getTryCount()).isEqualTo(5);
    }

    @Test
    public void 앞으로_가는지() {
        Car car = race.getCarList().get(0);
        car.goCar(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}