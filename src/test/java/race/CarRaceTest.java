package race;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CarRaceTest {

    @Test
    void 입력받은_자동차_이름들과_횟수를_가지고_CarRace를_생성한다() {
        String[] carNames = {"pobi", "crong", "honux"};
        int tryCount = 2;
        int carCount = carNames.length;

        CarRace carRace = new CarRace(carNames, tryCount);

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
        String[] carNames = {"pobi", "crong", "honux"};
        int carCount = carNames.length;
        int tryCount = 2;

        CarRace carRace = new CarRace(carNames, tryCount);

        List<String> raceResult = carRace.getRaceResult();

        assertThat(raceResult).hasSize(carCount);
        assertThat(raceResult).containsExactlyInAnyOrder("pobi", "crong", "honux");
    }
}
