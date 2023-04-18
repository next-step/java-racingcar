package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    @DisplayName("MAX_POSITION == 4")
    public void updateMaxPosition_ReturnTrue() {
        List<RacingCar> racingCarList = new ArrayList<RacingCar>();
        racingCarList.add(new RacingCar("test", 4));
        racingCarList.add(new RacingCar("test2", 3));

        Racing racing = new Racing(racingCarList);

        for (RacingCar racingCar : racingCarList) {
            racing.updateMaxPosition(racingCar.position());
        }

        int result = racing.maxPosition();

        assertThat(result).isEqualTo(4);
    }

//    @Test
//    @DisplayName("5대 자동차, 4번 움직임 시도(postion max값 == 4)인 racing 확인")
//    public void checkRacingClass() {
//        String[] test =  new String[] {"pobi","next","step","fight","test"};
//        Racing racing = new Racing(new RacingCars(test));
//        MoveStrategy randomMoveStrategy = new RandomMoveStrategy();
//        int numberOfTrials = 4;
//
//        while (numberOfTrials > 0) {
//            racing.startRacingRound(randomMoveStrategy);
//            numberOfTrials--;
//        }
//
//        assertThat(racing.statusOfRacing()).hasSize(5);
//        assertThat(racing.statusOfRacing().get(0).position())
//                .isLessThanOrEqualTo(4);
//    }
}