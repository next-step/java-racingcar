package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

public class RaceTest {

    Race mockRace;
    String[] mockCars;

    @Test
    @DisplayName("레이스 한 라운드 실행")
    void runRace() {
        mockCars = new String[2];
        mockCars[0] = "car1";
        mockCars[1] = "car2";

        mockRace = new Race();
        mockRace.setUpRace(mockCars);

        mockRace.runOneRound();
        Set<Car> cars = mockRace.getCars().getCarSet();

        for (Car car : cars) {
            assertThat(car.getCarProperty().getStep()).isBetween(0, 1);
        }
    }

}
