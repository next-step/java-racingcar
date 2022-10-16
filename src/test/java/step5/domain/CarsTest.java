package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    public void 우승한_자동차_목록을_반환할_수_있다() {
        Cars cars = Cars.of(List.of("1", "2", "3", "3"), new MoveStrategy());
        for (Car car : cars) {
            moveCar(car);
        }
        for (Car car : cars.getWinners()) {
            assertThat(car.name()).isEqualTo("3");
        }
    }

    private void moveCar(Car car) {
        int location = Integer.parseInt(car.name());
        for (int i = 0; i < location; i++) {
            car.moveOrStop();
        }
    }
}
