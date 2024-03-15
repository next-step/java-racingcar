package racingCar.findWinners;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NameOfWinnersTest {
    @Test
    @DisplayName("최대 거리 구하기")
    void max_position() {
        RacingCar racingCarA = new RacingCar("A", 3);
        RacingCar racingCarB = new RacingCar("B", 4);
        RacingCar racingCarC = new RacingCar("C", 5);

        List<RacingCar> racingCarList = Arrays.asList(racingCarA,racingCarB,racingCarC);

        NameOfWinners name = new NameOfWinners();

        assertThat(name.findWinner(racingCarList)).isEqualTo(Arrays.asList("C"));
    }
}
