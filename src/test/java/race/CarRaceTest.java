package race;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRaceTest {

    private ForwardCheck checkCarForward;

    @BeforeEach
    void setUp() {
        checkCarForward = new CarForwardCheck();
    }

    @Test
    void 입력받은_자동차_이름들과_횟수를_가지고_CarRace를_생성한다() {
        String[] carNames = {"pobi", "crong", "honux"};
        int tryCount = 2;
        int carCount = carNames.length;

        CarRace carRace = new CarRace(carNames, tryCount, checkCarForward);

        List<Car> cars = carRace.getCars();
        List<String> createdCarNames = new ArrayList<>();

        for (Car car : cars) {
            createdCarNames.add(car.getCarName());
        }

        assertThat(carRace.getCars()).hasSize(carCount);
        assertThat(createdCarNames).containsExactlyInAnyOrder(carNames);
    }

    @Test
    void round가_진행되고_isForward가_true라면_자동차가_조건에_맞게_전진한다() {
        String[] carNames = {"pobi", "crong", "honux"};
        int carCount = carNames.length;
        int tryCount = 2;

        CarRace carRace = new CarRace(carNames, tryCount, new FixedGo());

        List<Car> raceResult = carRace.proceedRound();

        assertThat(raceResult).hasSize(carCount);
        assertThat(raceResult.get(0).getForwardResult()).isEqualTo(2);
    }

    @Test
    void round가_진행되고_isForward가_false라면_자동차가_처음_진행상태로_머무른다() {
        String[] carNames = {"pobi", "crong", "honux"};
        int carCount = carNames.length;
        int tryCount = 2;

        CarRace carRace = new CarRace(carNames, tryCount, new FixedStay());

        List<Car> raceResult = carRace.proceedRound();

        assertThat(raceResult).hasSize(carCount);
        assertThat(raceResult.get(0).getForwardResult()).isEqualTo(1);
    }

    @Test
    void getRaceResult를_실행하면_자동차_경주_결과_가장_멀리_간_자동차의_이름들을_가져온다() {
        String[] carNames = {"pobi", "crong", "honux"};
        int carCount = carNames.length;
        int tryCount = 2;

        CarRace carRace = new CarRace(carNames, tryCount, new FixedGo());

        List<String> raceResult = carRace.getRaceResult();

        assertThat(raceResult).hasSize(carCount);
        assertThat(raceResult).containsExactlyInAnyOrder("pobi", "crong", "honux");
    }
}
