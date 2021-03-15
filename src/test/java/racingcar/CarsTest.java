package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void createInstance() {
        String[] carName = {"carname1", "carname2", "carname3"};
        cars = new Cars(carName);
    }

    @DisplayName("Cars 객체 생성시 Car 객체 생성하여 Car Size 테스트")
    @Test
    void generateCars() {
        // GIVE
        // WHEN
        // THAT
        assertThat(cars.getCars()).hasSize(3);
    }

    @DisplayName("Cars playCarGame 실행 시 car move 이동 테스트")
    @Test
    void playCarGame() {
        // GIVE
        // WHEN
        cars.playCarGame();
        // THAT
        assertThat(cars.getCars().stream().map(Car::getPosition)).isNotNull();
    }

    @DisplayName("Cars 값 깊은 복사 테스트")
    @Test
    void copyCars() {
        // GIVE
        // WHEN
        List<Car> deepCopyCar = cars.copyCars();
        List<Car> shallowCopyCar = cars.getCars();
        cars.getCars().get(0).move(() -> true);
        // THAT

        assertThat(deepCopyCar.get(0).getPosition())
                .isNotEqualTo(cars.getCars().get(0).getPosition());

        assertThat(shallowCopyCar.get(0).getPosition())
                .isEqualTo(cars.getCars().get(0).getPosition());

    }
}
