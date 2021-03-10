package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    Car car;

    @ParameterizedTest
    @MethodSource("moveTestSource")
    @DisplayName("자동차는 4이상이 입력되어야 전진")
    void canMoveForward (Car car, int expected) {
        assertThat(car.getPosition().getPosition()).isEqualTo(expected);
    }

    private static Stream<Arguments> moveTestSource() {
        final int move = 4;
        final int stop = 3;
        Car car1 = new NextStepCar("dummy");
        Car car2 = new NextStepCar("dummy");
        Car car3 = new NextStepCar("dummy");
        Car car4 = new NextStepCar("dummy");
        Car car5 = new NextStepCar("dummy");
        Car car6 = new NextStepCar("dummy");
        Car car7 = new NextStepCar("dummy");

        car1.moveForward(move);

        car2.moveForward(move);
        car2.moveForward(move);

        car3.moveForward(move);
        car3.moveForward(move);
        car3.moveForward(move);

        car4.moveForward(move);
        car4.moveForward(move);
        car4.moveForward(move);
        car4.moveForward(move);

        car5.moveForward(stop);

        car6.moveForward(move);
        car6.moveForward(move);
        car6.moveForward(stop);
        car6.moveForward(stop);
        car6.moveForward(stop);
        car6.moveForward(stop);

        car7.moveForward(stop);
        car7.moveForward(stop);
        car7.moveForward(stop);
        car7.moveForward(stop);
        car7.moveForward(stop);
        car7.moveForward(stop);
        car7.moveForward(stop);
        car7.moveForward(stop);
        car7.moveForward(stop);

        return Stream.of(
                Arguments.of(car1, 1)
                , Arguments.of(car2, 2)
                , Arguments.of(car3, 3)
                , Arguments.of(car4, 4)
                , Arguments.of(car5, 0)
                , Arguments.of(car6, 2)
                , Arguments.of(car7, 0)
        );
    }


    @Test
    @DisplayName("여러대의 자동차 전진")
    void isMoveOrStopCar () {
        List<Car> cars = new ArrayList<>();
        cars.add(new NextStepCar("dummy"));
        cars.add(new NextStepCar("dummy"));
        cars.add(new NextStepCar("dummy"));
        cars.add(new NextStepCar("dummy"));
        cars.add(new NextStepCar("dummy"));

        for(Car car: cars) {
            assertThat(car.moveForward(4)).isEqualTo(1);
            assertThat(car.moveForward(5)).isEqualTo(2);
            assertThat(car.moveForward(6)).isEqualTo(3);
            assertThat(car.moveForward(7)).isEqualTo(4);
            assertThat(car.moveForward(8)).isEqualTo(5);
        }
        assertThat(cars.get(0).getPosition().getPosition()).isEqualTo(5);
        assertThat(cars.get(1).getPosition().getPosition()).isEqualTo(5);
        assertThat(cars.get(2).getPosition().getPosition()).isEqualTo(5);
        assertThat(cars.get(3).getPosition().getPosition()).isEqualTo(5);
        assertThat(cars.get(4).getPosition().getPosition()).isEqualTo(5);
    }

    @Test
    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    void mustOverFourCanMoveForward() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            Car car = new NextStepCar("dummy");
            assertThat(car.moveForward(randomNumber)).isEqualTo(1);
        }
        if (randomNumber < 4) {
            Car car = new NextStepCar("dummy");
            assertThat(car.moveForward(randomNumber)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("2대만 테스트 (일단 간단히)")
    void simpleRacingCar() {
        List<Car> cars = new ArrayList<>();
        cars.add(new NextStepCar("dummy"));
        cars.add(new NextStepCar("dummy"));

        Random random = new Random();
        cars.get(0).moveForward(random.nextInt(10));
        cars.get(0).moveForward(random.nextInt(10));
        cars.get(0).moveForward(random.nextInt(10));
        cars.get(0).moveForward(random.nextInt(10));
        cars.get(0).moveForward(random.nextInt(10));
        cars.get(0).moveForward(random.nextInt(10));
        cars.get(0).moveForward(random.nextInt(10));

        cars.get(1).moveForward(random.nextInt(10));
        cars.get(1).moveForward(random.nextInt(10));
        cars.get(1).moveForward(random.nextInt(10));
        cars.get(1).moveForward(random.nextInt(10));
        cars.get(1).moveForward(random.nextInt(10));
        cars.get(1).moveForward(random.nextInt(10));
        cars.get(1).moveForward(random.nextInt(10));

        assertThat(cars.get(0).getPosition()).isNotEqualTo(cars.get(1).getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"봉봉봉봉봉봉카", "봉봉봉일균카", "넥스트스탭카"})
    @DisplayName("자동차명은 5자이하허용")
    void carNames(String carName) {
        assertThatThrownBy(() -> {
            Car car = new NextStepCar(carName);
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"봉카,봉일균카,넥스트카"})
    @DisplayName("이름을 입력받다 - 쉼표로 구분")
    void splitByCommas(String carNames) {
        List<Car> carList = new ArrayList<>();
        for(String carName: carNames.split(",")) {
            carList.add(new NextStepCar(carName));
        }
        NextStepCars nextStepCars = new NextStepCars(carList);
        assertThat(nextStepCars.carCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자찾기 단건")
    void winnerOnlyOne() {
        String carNames = "봉,봉봉,봉봉봉,봉봉봉봉";
        List<Car> carList = new ArrayList<>();
        int moveIndex = 1;

        for(String carName: carNames.split(",")) {
            NextStepCar car = new NextStepCar(carName);
            car.moveForward(moveIndex++);
            carList.add(car);
        }
        NextStepCars nextStepCars = new NextStepCars(carList);
        assertThat(nextStepCars.getWinner().get(0)).isEqualTo("봉봉봉봉");
    }

    @Test
    @DisplayName("우승자찾기 다건")
    void winnerMultiple() {
        String carNames = "봉,봉봉,봉봉봉,봉봉봉봉";
        List<Car> carList = new ArrayList<>();
        int moveIndex = 1;

        for(String carName: carNames.split(",")) {
            NextStepCar car = new NextStepCar(carName);
            car.moveForward(moveIndex++);
            carList.add(car);
        }
        NextStepCar expectedSecondWinner = new NextStepCar("붕");
        expectedSecondWinner.moveForward(moveIndex-1);
        carList.add(expectedSecondWinner);

        NextStepCars nextStepCars = new NextStepCars(carList);
        List<String> winners = nextStepCars.getWinner();
        assertThat(winners.size()).isEqualTo(2);
    }

    @BeforeEach
    void init() {
        car = new NextStepCar("dummy");
    }
}