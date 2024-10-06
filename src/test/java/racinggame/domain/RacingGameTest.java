package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car.CarDto;
import racinggame.domain.RacingGame;
import racinggame.domain.SnapShotStore.SnapShot;

public class RacingGameTest {


    @Test
    public void 이동횟수만큼_이동_테스트() {
        int repeat = 4;
        List<List<Integer>> repeatAndCapacities = new ArrayList<>();
        for (int i = 0; i < repeat; i++) {
            repeatAndCapacities.add(List.of(4, 3, 4, 4));
        }
        RacingGame racingGame = new RacingGame(4);
        racingGame.start(repeatAndCapacities);

        SnapShot result = racingGame.matchResult();
        assertThat(result.getSnapShot(result.repeatCount() - 1)).isEqualTo(
                carDtos(repeat + 1, 1, repeat + 1, repeat + 1));
    }

    private static List<CarDto> carDtos(int... positions) {
        ArrayList<CarDto> result = new ArrayList<>();
        for (int position : positions) {
            result.add(new CarDto(position));
        }
        return result;
    }

}
