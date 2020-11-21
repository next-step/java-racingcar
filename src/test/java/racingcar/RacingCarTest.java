package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    String[] carNames = {"john", "tom", "myung"};
    Car car = new Car();

    @BeforeAll
    static void beforeAll() {
        Car car = new Car();
    }

    @DisplayName("입력split테스트")
    @Test
    void inputCarNamesTest() {
        String[] inputNames = InputView.splitCarNames("john,tom,myung");
        assertThat(inputNames).isEqualTo(carNames);
    }

    @DisplayName("입력정상")
    @Test
    void carNamesValidationTest_SUCCESS() {
        boolean result = CarRace.carNamesValidation("john,tom,myung");
        assertTrue(result);
    }

    @DisplayName("5자이상입력")
    @Test
    void carNamesValidationTest_FAIL() {
        boolean result = CarRace.carNamesValidation("john,tom,petrucci");
        assertFalse(result);
    }

    @DisplayName("기본출력")
    @Test
    void print() {
        CarRace carRace = new CarRace(carNames, 5);
        carRace.race();
        ResultView.print(carRace);
    }

    @DisplayName("차량셋팅")
    @Test
    void initCar() {
        CarRace carRace = new CarRace(carNames, 5);
        assertThat(carRace.getCars()).hasSize(3);
    }

    @DisplayName("4이상전진")
    @Test
    void carMoveSuccess() {
        car.go(4);
        assertTrue(car.equalDistance(2));
    }

    @DisplayName("10번전진")
    @Test
    void carMove2() {
        for(int i=0; i<10; i++){
            car.go(10);
        }
        assertThat(car.getDistance()).isGreaterThan(10);
    }

    @DisplayName("4미만전진하지않음")
    @Test
    void carMovefail() {
        car.go(3);
        assertThat(car.equalDistance(1)).isTrue();
    }

    @DisplayName("레이스스냅샷확인")
    @Test
    void raceSnapshot() {
        car.go(5);
        assertThat(car.snapshot().getDistance()).isEqualTo(2);
        car.go(5);
        assertThat(car.snapshot().getDistance()).isEqualTo(3);
    }

    @DisplayName("가장많이간거리확인")
    @Test
    void getWinnerDistanceTest() {
        CarRace carRace = new CarRace(carNames, 3);
        Car car = new Car("test");
        car.go(10);
        car.go(10);
        ArrayList<CarSnapshot> carSnapshotArrayList = new ArrayList<>();
        carSnapshotArrayList.add(car.snapshot());
        RaceSnapshot raceSnapshot = new RaceSnapshot(carSnapshotArrayList);
        ArrayList<RaceSnapshot> raceSnapshotArrayList = new ArrayList<>();
        raceSnapshotArrayList.add(raceSnapshot);
        int winenrDistance = carRace.getWinnerDistance(raceSnapshotArrayList.get(raceSnapshotArrayList.size()-1));
        assertThat(winenrDistance).isEqualTo(3);
    }

    @DisplayName("우승자확인")
    @Test
    void getWinnerCarsTest() {
        CarRace carRace = new CarRace(carNames, 3);
        Car car = new Car("test");
        car.go(10);
        car.go(10);
        Car car2 = new Car("test2");
        car2.go(10);
        ArrayList<CarSnapshot> carSnapshotArrayList = new ArrayList<>();
        carSnapshotArrayList.add(car.snapshot());
        RaceSnapshot raceSnapshot = new RaceSnapshot(carSnapshotArrayList);
        ArrayList<RaceSnapshot> raceSnapshotArrayList = new ArrayList<>();
        raceSnapshotArrayList.add(raceSnapshot);
        carRace.setRaceResult(raceSnapshotArrayList);
        List<Car> winnerCars = carRace.getWinnerCars();
        assertThat(winnerCars.get(0).getName()).isEqualTo("test");
    }
}
