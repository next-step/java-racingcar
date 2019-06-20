package step4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.CarNames;
import step3.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car = new Car("testCar");

    @Test
    void 자동차가_생성된다() {
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차_이름이_제대로_생성된다() {
        assertThat(car.getCarName()).isEqualTo("testCar");
    }

    @Test
    void 생성된_자동차의_시작포지션은_0이다() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 입력된_이름대로_자동차의_이름들이_생성된다(int num) {
        String inputString = "Car0,Car1,Car2,Car3,Car4";
        String[] carNameArray = inputString.split(",");
        CarNames carNames = CarNames.makeCarNames(carNameArray);

        assertThat(carNames.getCarNames().get(num)).isEqualTo("Car" + num);
    }

    @Test
    void 입력된_이름의_숫자만큼_자동차가_생성된다() {
        String inputString = "Car1,Car2,Car3,Car4,Car5";
        String[] carNameArray = inputString.split(",");
        CarNames carNames = CarNames.makeCarNames(carNameArray); //TODO: Q. 위의 코드와 중복되는데 상관 없을까요?
        Cars cars = Cars.makeCars(carNames);

        assertThat(cars.getCars().size()).isEqualTo(5);
    }

    @Test
    void 자동차는_랜덤숫자가_4이상인_경우_이동한다() {
        int randomNumberOverFour = 5;
        int initialPosition = car.getPosition();
        car.move(randomNumberOverFour);

        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Test
    void 자동차는_랜덤숫자가_4미만인_경우_이동하지_않는다() {
        int randomNumberUnderFour = 3;
        int initialPosition = car.getPosition();
        car.move(randomNumberUnderFour);

        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 자동차가_이동기준을_통과한_횟수만큼_이동한다(int numberOfMoves) {
        final int aboveMoveCriterionNumber = 5;
        for (int i = 0; i < numberOfMoves; i++) {
            car.move(aboveMoveCriterionNumber);
        }
        assertThat(car.getPosition()).isEqualTo(numberOfMoves);
    }

}
