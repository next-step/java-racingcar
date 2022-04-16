package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerRacingCarsTest {
    @Test
    @DisplayName("우승차 문구를 반환하는 테스트")
    void winnerCarsStringTest() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("CarA"));
        cars.add(new Car("CarB"));


        WinnerRacingCars winnerRacingCars = new WinnerRacingCars(new RacingCars(cars));

        assertThat(winnerRacingCars.toString()).isEqualTo("CarA, CarB가 최종 우승했습니다.");
    }
}
