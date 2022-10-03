package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
        Set<Car> cars = mockRace.getCars().getCars();

        for (Car car : cars) {
            assertThat(car.getPosition())
                    .isBetween(0, 1);
        }
    }

}
