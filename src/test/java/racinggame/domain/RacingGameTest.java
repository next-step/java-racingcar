package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car.CarDto;
import racinggame.domain.RacingGame;
import racinggame.domain.SnapShotStore.SnapShot;
import racinggame.random.Radom;

public class RacingGameTest {


    @Test
    public void 이동횟수만큼_이동_테스트() {
        int repeat = 4;

        RacingGame racingGame = new RacingGame(repeat,4);
        SnapShot result =  racingGame.start(new TestNumberGenerator(4));

        assertThat(result.getSnapShot(result.repeatCount() - 1)).isEqualTo(
                carDtos(repeat + 1, repeat+1, repeat + 1, repeat + 1));
    }

    private static List<CarDto> carDtos(int... positions) {
        ArrayList<CarDto> result = new ArrayList<>();
        for (int position : positions) {
            result.add(new CarDto(position));
        }
        return result;
    }

    static class TestNumberGenerator implements Radom{

        private Integer value;

        public TestNumberGenerator(Integer value) {
            this.value = value;
        }

        @Override
        public int generate() {
            return value;
        }
    }

}
