package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void beforeEach() {
        cars = new Cars();
    }

    @Test
    @DisplayName("자동차 객체 생성 확인")
    void confirmCarObjectCreation() {
        cars.create(new RandomMovingStrategy(), new String[]{"pobi", "crong", "honux"});

        List<Car> result = cars.getCars();

        assertThat(result).hasSize(3);
    }

    @Test
    @DisplayName("자동차 경주 우승자 찾기")
    void findCarRacingWinner() {
        cars.getCars().add(new Car(new Position(1), new RandomMovingStrategy(), "pobi"));
        cars.getCars().add(new Car(new Position(3), new RandomMovingStrategy(), "crong"));
        cars.getCars().add(new Car(new Position(5), new RandomMovingStrategy(), "honux"));

        List<String> result = cars.getWinnerNames();

        assertThat(result).containsExactly("honux");
    }
}