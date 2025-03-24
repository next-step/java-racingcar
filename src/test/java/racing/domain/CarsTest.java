package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.model.Car;
import racing.domain.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {

    @Test
    @DisplayName("자동차의 이름으로 Cars 객체를 초기화 할 수 있다.")
    void createCarsFromNames() {
        String[] carNames = {"Tesla", "BMW", "Audi"};

        Cars cars = new Cars(carNames);

        List<Car> carList = cars.getAll();

        assertAll(
                () -> assertNotNull(carList),
                () -> assertThat(carList).hasSize(3),
                () -> assertThat(carList.get(0).getName()).isEqualTo("Tesla"),
                () -> assertThat(carList.get(1).getName()).isEqualTo("BMW"),
                () -> assertThat(carList.get(2).getName()).isEqualTo("Audi")
        );
    }

    @Test
    @DisplayName("자동차의 이름이 최대 길이를 초과할 경우 IllegalArgumentException 가 발생한다.")
    void throwExceptionWhenCarNameExceedsFiveCharacters() {
        String[] carNames = {"Tesla", "Hyundai", "Audi"};

        assertThrows(IllegalArgumentException.class, () -> new Cars(carNames));
    }

    @Test
    @DisplayName("모든 자동차가 같은 위치에 있을 경우 모든 자동차가 우승자가 된다.")
    void getWinnersWithAllCarsAtSamePosition() {
        String[] carNames = {"Tesla", "BMW", "Audi"};
        Cars cars = new Cars(carNames);

        List<Car> winners = cars.getWinners();

        assertAll(
                () -> assertNotNull(winners),
                () -> assertThat(winners).hasSize(3),
                () -> assertThat(winners).containsExactlyElementsOf(cars.getAll())
        );
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승자가 된다.")
    void getWinnersWithOneCar() {
        String[] carNames = {"Tesla", "BMW", "Audi"};
        Cars cars = new Cars(carNames);
        Car leadingCar = cars.getAll().get(0);

        leadingCar.moveForward();

        List<Car> winners = cars.getWinners();

        assertAll(
                () -> assertNotNull(winners),
                () -> assertThat(winners).hasSize(1),
                () -> assertThat(winners.get(0)).isEqualTo(leadingCar)
        );
    }
}
