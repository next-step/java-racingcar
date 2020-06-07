package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.Cars;
import racing.util.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("레이싱카 클래스 테스트")
class CarsTest {

    @Test
    @DisplayName("자동차 대수 테스트")
    void racingCarSizeTest() {
        //given
        int expectedCarCount = 4;
        String carNames = "test1, test2, test3";
        Cars cars = new Cars(carNames);
        cars.addCar(new Car("test4"));
        //when
        List<Car> carList = cars.getCars();
        //then
        assertThat(carList).hasSize(expectedCarCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ,1 ,2", " ,3, ", "1 , , 3"})
    @DisplayName("자동차들의 이름 문자열에 공백이름이 들어가는지 확인 테스트")
    void nameBlankCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(input));
    }

    @Test
    @DisplayName("가장 많이 이동한 차의 position을 찾는 테스트")
    void getWinnerPositionTest() {

        String carNames = "test1, test2, test3";
        Cars cars = new Cars(carNames);
        int carCount = cars.getJoinedCarCount();
        cars.carsMove(Dice.castByCarCount(carCount));
        cars.carsMove(Dice.castByCarCount(carCount));
        cars.carsMove(Dice.castByCarCount(carCount));
        cars.carsMove(Dice.castByCarCount(carCount));
        cars.carsMove(Dice.castByCarCount(carCount));

        List<Car> carList = cars.getCars();

        int winnerPosition = 0;
        for (Car car : carList) {
            int position = car.getPosition();
            if (winnerPosition <= position) {
                winnerPosition = position;
            }
        }
        assertThat(winnerPosition).isEqualTo(cars.getWinnerPosition());
    }


    @Test
    @DisplayName("2 라운드의 스냅샷과 2라운드의 자동차, 마지막 라운드의 자동차를 각각 비교하여 deep copy가 잘 되는지 확인하는 테스트")
    void getDeepCopyRacingCarsTest() {

        String carNames = "test1, test2, test3";
        Cars cars = new Cars(carNames);
        int carCount = cars.getJoinedCarCount();
        cars.carsMove(Dice.castByCarCount(carCount));
        cars.carsMove(Dice.castByCarCount(carCount));
        List<Car> roundCarList = cars.getCars();
        List<Car> snapShot = cars.getDeepCopyRacingCars().getCars();
        List<Car> comparedSameCarList = new ArrayList<>();

        for (Car targetCar : roundCarList) {
            for (Car car : snapShot) {
                if (targetCar.getName().equals(car.getName()) && targetCar.getPosition() == car.getPosition()) {
                    comparedSameCarList.add(car);
                }
            }
        }

        int round2More = 2;
        for (int j = 0; j < round2More; j ++) {
            for (Car car : roundCarList) {
                car.move(4);
            }
        }

        assertThat(comparedSameCarList).hasSize(carCount);

        List<Car> comparedSameCarList2 = new ArrayList<>();

        for (Car targetCar : roundCarList) {
            for (Car car : snapShot) {
                if (targetCar.getName().equals(car.getName()) && targetCar.getPosition() == car.getPosition()) {
                    comparedSameCarList2.add(car);
                }
            }
        }

        assertThat(carCount).isNotEqualTo(comparedSameCarList2.size());
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true", "6:true"}, delimiter = ':')
    @DisplayName("차가 이동했는지 안했는지 확인하는 테스트")
    void carMoveTesT(int input, boolean expected) {
        String carNames = "test1";
        Cars cars = new Cars(carNames);
        assertThat(cars.getCars().size()).isEqualTo(1);

        cars.carsMove(Collections.singletonList(input));
        Car car = cars.getCars().get(0);

        assertThat(car.getPosition() > 0).isEqualTo(expected);
    }
}