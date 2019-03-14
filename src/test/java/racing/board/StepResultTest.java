package racing.board;

import org.junit.*;
import racing.model.NamedRacingCar;
import racing.model.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepResultTest {

    @Test
    public void test_생성_후_복사된_자동차_동일성() {
        List<RacingCar> originCars = Arrays.asList(new RacingCar(), new NamedRacingCar("pobi"));
        StepResult stepResult = new StepResult(originCars);

        List<RacingCar> copiedCars = stepResult.getCars();
        assertThat(originCars).doesNotContain(copiedCars.toArray(new RacingCar[copiedCars.size()]));
    }
}