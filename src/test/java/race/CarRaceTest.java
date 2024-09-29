package race;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRaceTest {

    public static final boolean FIX_FORWARD_CONDITION = true;
    public static final boolean FIX_UNFORWARD_CONDITION = false;
    private RandomNumber checkCarForward;

    @BeforeEach
    void setUp() {
        checkCarForward = new CarRandomNumber();
    }

    @Test
    void 입력받은_자동차_대수와_횟수를_가지고_CarRace를_생성한다() {
        int carCount = 2;
        int tryCount = 2;

        CarRace carRace = new CarRace(carCount, tryCount, checkCarForward);

        assertThat(carRace.getCars()).hasSize(carCount);
    }

    @Test
    void round가_진행되고_isForward가_true라면_자동차가_조건에_맞게_전진한다() {
        int carCount = 2;
        int tryCount = 2;

        FixedCheckForward goCondition = new FixedCheckForward(FIX_FORWARD_CONDITION);

        CarRace carRace = new CarRace(carCount, tryCount, goCondition);

        List<Car> raceResult = carRace.proceedRound();

        assertThat(raceResult).hasSize(carCount);
        assertThat(raceResult.get(0).getForwardResult()).isEqualTo(2);
    }

    @Test
    void round가_진행되고_isForward가_false라면_자동차가_처음_진행상태로_머무른다() {
        int carCount = 2;
        int tryCount = 2;

        FixedCheckForward stayCondition = new FixedCheckForward(FIX_UNFORWARD_CONDITION);

        CarRace carRace = new CarRace(carCount, tryCount, stayCondition);

        List<Car> raceResult = carRace.proceedRound();

        assertThat(raceResult).hasSize(carCount);
        assertThat(raceResult.get(0).getForwardResult()).isEqualTo(1);
    }
}
