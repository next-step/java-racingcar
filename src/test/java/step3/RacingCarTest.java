package step3;

import static org.assertj.core.api.Assertions.assertThat;


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
}