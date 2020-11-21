package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarSnapshotTest {

    String[] carNames = {"john", "tom", "myung"};
    Car car = new Car();

    @BeforeAll
    static void beforeAll() {
        Car car = new Car();
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

}
