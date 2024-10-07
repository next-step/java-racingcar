package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
    @BeforeEach
    void setUp() {
        Cars.clear();
    }

    @Test
    @DisplayName("우승자를 가져오는지 확인")
    void getWinners() {
        Car car1 = new Car("truck");
        Car car2 = new Car("pobi");
        Cars.addCar(car1);
        Cars.addCar(car2);

        car1.move(true);
        car2.move(false);

        List<Car> winners = Winner.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners).extracting(Car::getName)
                           .containsExactly("truck");
    }

    @Test
    @DisplayName("우승자 여러명을 가져오는지 확인")
    void getWinners_여러명() {
        Car car1 = new Car("truck");
        Car car2 = new Car("pobi");
        Car car3 = new Car("crong");
        Cars.addCar(car1);
        Cars.addCar(car2);
        Cars.addCar(car3);


        car1.move(true);
        car2.move(true);
        car3.move(false);

        List<Car> winners = Winner.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting(Car::getName)
                           .containsExactlyInAnyOrder("truck", "pobi");
    }
}
