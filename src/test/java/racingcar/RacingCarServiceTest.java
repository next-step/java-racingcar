package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.application.RacingCarService;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCommand;
import racingcar.domain.MoveType;
import racingcar.utils.TestNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarServiceTest {

    //차량 이름 길이는 5글자를 초과하면 안되고 중복되면 안됨.
    private final List<String> validCarNames = List.of("test1", "test2", "test3");

    @ParameterizedTest
    @DisplayName("중복되지 않은 차량(이름)을 M 번 움직였을 경우 테스트")
    @CsvSource(value = {"0:0","1:0","2:0","3:0","4:2","5:2","6:2","7:2","8:2","9:2"}, delimiter = ':')
    void testMoveCar(int number, int expectedPosition) {
        int repeatCount = 2;

        RacingCarService racingCarService = new RacingCarService(new MoveCommand(new TestNumber(number)));
        racingCarService.initCars(validCarNames);

        for (int i = 0; i < repeatCount; i++) {
            racingCarService.moveCar();
        }

        List<Car> cars = racingCarService.cars();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            assertThat(car.getPosition()).isEqualTo(expectedPosition);
            assertThat(car.getName()).isEqualTo(validCarNames.get(i));
        }
    }

    @Test
    @DisplayName("우승 차량 반환 테스트")
    public void testWinnerCars() {
        List<Integer> carPositions = List.of(1,2,2);
        List<String> winnerCarNames = List.of("test2", "test3");
        Cars cars = makeCars(validCarNames, carPositions);
        List<Car> winners = cars.getWinnerCars();

        for (int i = 0; i < winners.size(); i++) {
            Car winner = winners.get(i);
            assertThat(winner.getName()).isEqualTo(winnerCarNames.get(i));
        }
    }

    @ParameterizedTest
    @DisplayName("차량 이름 중복된 경우 예외 발생")
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void testDuplicateCarNames(int number) {
        RacingCarService racingCarService = new RacingCarService(new MoveCommand(new TestNumber(number)));

        String carName = "test";
        List<String> duplicateCarNames = List.of(carName, carName);

        assertThatThrownBy(() -> racingCarService.initCars(duplicateCarNames)).isInstanceOf(RuntimeException.class);
    }


    @Test
    @DisplayName("차량을 만들기 전에, 이동하면 예외 발생")
    void testMoveCarBeforeMakeCars() {
        RacingCarService racingCarService = new RacingCarService(new MoveCommand(new TestNumber(0)));
        assertThatThrownBy(racingCarService::moveCar).isInstanceOf(RuntimeException.class);
    }

    private Cars makeCars(List<String> carNames, List<Integer> carPositions) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(makeCar(carNames.get(i), carPositions.get(i)));
        }

        return new Cars(cars);
    }

    private Car makeCar(String name, int position) {
        Car car = new Car(name);

        for (int i = 0; i < position; i++) {
            car.move(MoveType.FORWARD);
        }

        return car;
    }
}
