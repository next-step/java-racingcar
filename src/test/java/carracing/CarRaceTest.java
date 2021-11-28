package carracing;

import carracing.cars.CarName;
import carracing.cars.StepForwardStrategy;
import carracing.rounds.Rounds;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class CarRaceTest {
    @Test
    @DisplayName("CarRace 에서 race를 진행하고 우승자를 검사한다.")
    void carRace() {
        List<CarName> carNames = new ArrayList<>();
        carNames.add(new CarName("car1"));
        carNames.add(new CarName("car2"));
        int round = 5;


        StepForwardStrategy alwaysStepForward = () -> true;
        CarRace carRace = new CarRace(carNames, round, alwaysStepForward);

        Rounds rounds = carRace.race();
        assertThat(rounds.getWinners()).isEqualTo(carNames);
    }

    @Test
    @DisplayName("각 CarRace는 한번만 진행할 수 있다.")
    void raceOnce() {
        List<CarName> carNames = new ArrayList<>();
        carNames.add(new CarName("car1"));
        carNames.add(new CarName("car2"));
        int round = 5;


        StepForwardStrategy alwaysStepForward = () -> true;
        CarRace carRace = new CarRace(carNames, round, alwaysStepForward);

        carRace.race();

        assertThatIllegalStateException().isThrownBy(carRace::race);
    }
}
