package step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;
import step3.domain.CarName;
import step3.domain.Cars;
import step3.domain.MoveCars;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:4:0", "2:4:0", "4:4:1", "5:4:1"}, delimiter = ':')
    void move(int input, int decisionValue, int expected) {
        Car car = new Car("test", 0);
        car.move(input, decisionValue);
        assertThat(car.position()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:abc,def,hig,lmn", "6:aaa,bbb,ccc,ddd,eee,fff"}, delimiter = ':')
    void process(int turnCount, String carNames) {
        Cars cars = new Cars(CarName.splitCarNames(carNames), 0);
        MoveCars moveCars = new MoveCars(turnCount, 4, cars);
        moveCars.race();
        cars.getCars().forEach((car) -> {
            assertThat(car.position()).isBetween(0, turnCount);
        });
    }
}