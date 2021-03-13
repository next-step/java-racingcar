package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.module.RandomStrategy;
import racingcar.util.ValidationUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void createInstance() {
        cars = new Cars(3);
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
}
