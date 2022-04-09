package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("아규먼트로 들어온 숫자만큼 자동차들은 이동한다.")
    void carsMovementTest() {
        //given
        Car car1 = new Car("자동차1");
        Car car2 = new Car("자동차2");
        Car car3 = new Car("자동차3");

        car1.move(1);
        car1.move(2);
        car1.move(3);

        List<Integer> movementList = List.of(1, 2, 3);
        Cars testCars = new Cars(List.of(new Car("자동차1"), new Car("자동차2"), new Car("자동차3")));

        //when
        List<CarLocationResult> carLocationResults = testCars.move(movementList);

        //then
        assertThat(carLocationResults).containsExactly(
                CarLocationResult.from(car1),
                CarLocationResult.from(car2),
                CarLocationResult.from(car3)
        );
    }

    @Test
    @DisplayName("우승자 1명임을 확인한다.")
    void winnerTest() {
        //given
        Car car1 = new Car("자동차1");
        Car car2 = new Car("자동차2");
        Car car3 = new Car("자동차3");

        car1.move(4);
        car1.move(3);
        car1.move(3);

        //when
        Cars testCars = new Cars(List.of(car1, car2, car3));
        List<CarName> winners = testCars.getWinners();

        //then
        assertThat(winners.size()).isOne();
        assertThat(winners.get(0).getName()).isEqualTo(car1.getCarName());
    }

    @Test
    @DisplayName("우승자 2명을 확인한다.")
    void winnersTest() {
        //given
        Car car1 = new Car("자동차1");
        Car car2 = new Car("자동차2");
        Car car3 = new Car("자동차3");

        car1.move(7);
        car2.move(6);
        car3.move(3);

        //when
        Cars testCars = new Cars(List.of(car1, car2, car3));
        List<CarName> winners = testCars.getWinners();

        //then
        assertThat(winners.size()).isGreaterThanOrEqualTo(2);
        assertThat(winners).contains(new CarName("자동차1"));
        assertThat(winners).contains(new CarName("자동차2"));
    }

}