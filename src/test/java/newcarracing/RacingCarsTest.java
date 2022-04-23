package newcarracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    private List<RacingCar> tempCars;

    @BeforeEach
    void 테스트_리소스_초기화() {
        tempCars = new ArrayList<>();
        tempCars.add(new RacingCar("pobi", 5));
        tempCars.add(new RacingCar("crong", 2));
        tempCars.add(new RacingCar("honux", 3));
        tempCars.add(new RacingCar("pobi2", 5));
    }

    @Test
    void 자동차_최대_위치_확인() throws CloneNotSupportedException {
        RacingCars cars = new RacingCars(tempCars);
        List<RacingCar> winners = cars.getWinners();
        // System.out.println(winners.toString());
        assertThat(winners).hasSize(2);
        assertThat(winners).contains(new RacingCar("pobi", 5));
        assertThat(winners).contains(new RacingCar("pobi2", 5));
    }
}
