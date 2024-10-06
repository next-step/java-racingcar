package race;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CarRaceTest {

    @Test
    void 입력받은_자동차_이름들과_횟수를_가지고_CarRace를_생성한다() {
        String[] carNames = {"pobi", "crong", "honux"};
        int carCount = carNames.length;

        CarRace carRace = new CarRace(carNames, new TryCount(2));

        List<Car> cars = carRace.getCars();
        List<String> createdCarNames = new ArrayList<>();

        for (Car car : cars) {
            createdCarNames.add(car.getCarName());
        }

        assertThat(carRace.getCars()).hasSize(carCount);
        assertThat(createdCarNames).containsExactlyInAnyOrder(carNames);
    }

    @Test
    void getRaceResult를_실행하면_자동차_경주_결과_가장_멀리_간_자동차의_이름들을_가져온다() {
        List<Car> cars = List.of(
            new Car(new CarName("pobi"), new Position(4)),
            new Car(new CarName("max"), new Position(2)),
            new Car(new CarName("lili"), new Position(3))
        );

        CarRace carRace = new CarRace(cars, new TryCount(2));

        List<String> raceResult = carRace.getRaceResult();

        assertThat(raceResult).hasSize(1);
        assertThat(raceResult).isEqualTo(List.of("pobi"));
    }
}
