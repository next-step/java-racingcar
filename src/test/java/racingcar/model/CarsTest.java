package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {

    @Test
    @DisplayName("4 이상일 경우에 자동차들은 이동한다.")
    void carsMovementTest() {
        //given
        List<Boolean> movementList = List.of(false, true, true);
        List<Car> testCarList = List.of(Car.from("자동차1"), Car.from("자동차2"), Car.from("자동차3"));
        Cars testCars = new Cars(testCarList);

        //when
        testCars.move(movementList);

        //then
        assertAll(
                () -> assertThat(testCarList.get(0).getCurrentLocationValue()).isEqualTo(1),
                () -> assertThat(testCarList.get(1).getCurrentLocationValue()).isEqualTo(2),
                () -> assertThat(testCarList.get(2).getCurrentLocationValue()).isEqualTo(2)
        );

    }

    @Test
    @DisplayName("우승자 1명임을 확인한다.")
    void winnerTest() {
        //given
        Car car1 = Car.from("자동차1");
        Car car2 = Car.from("자동차2");
        Car car3 = Car.from("자동차3");

        car1.move(true);
        car1.move(false);
        car1.move(false);

        //when
        Cars testCars = new Cars(List.of(car1, car2, car3));
        List<CarName> winners = testCars.getWinners();

        //then
        assertThat(winners.size()).isOne();
        assertThat(winners.get(0).getName()).isEqualTo(car1.getCarNameValue());
    }

    @Test
    @DisplayName("우승자 2명을 확인한다.")
    void winnersTest() {
        //given
        Car car1 = Car.from("자동차1");
        Car car2 = Car.from("자동차2");
        Car car3 = Car.from("자동차3");

        car1.move(true);
        car2.move(true);
        car3.move(true);

        //when
        Cars testCars = new Cars(List.of(car1, car2, car3));
        List<CarName> winners = testCars.getWinners();

        //then
        assertThat(winners).hasSize(2);
        assertThat(winners).contains(new CarName("자동차1"));
        assertThat(winners).contains(new CarName("자동차2"));
    }

    @Test
    @DisplayName("사용자별 현재 위치를 변경하는 객체를 반환한다")
    void convertIntoCarLocationResultTest() {
        //given
        List<Car> carList = List.of(Car.from("자동차1"), Car.from("자동차2"), Car.from("자동차3"));
        Cars cars = new Cars(carList);

        //when
        List<CarLocationResult> carLocationResults = cars.getCarLocationResult();

        //then
        assertAll(
                () -> assertThat(carLocationResults.get(0).getCarName()).isEqualTo("자동차1"),
                () -> assertThat(carLocationResults.get(1).getCarName()).isEqualTo("자동차2"),
                () -> assertThat(carLocationResults.get(2).getCarName()).isEqualTo("자동차3")
        );
    }


}