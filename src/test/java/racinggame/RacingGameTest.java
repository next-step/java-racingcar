package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import racinggame.Car.CarDto;
import racinggame.RacingGame.SnapShot;

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
        assertThat(result.getSnapShot(result.repeatCount() - 1)).isEqualTo(carDtos(repeat, 0, repeat, repeat));
    }


    @Test
    public void 스냅샵_검증_테스트() {
        Random random = new Random();
        List<List<CarDto>> list = new ArrayList<>();
        int repeatCount = 5;
        for (int i = 0; i < repeatCount; i++) {
            list.add(carDtos(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10)));
        }
        SnapShot snapShot = new SnapShot(list);
        assertThat(snapShot.repeatCount()).isEqualTo(repeatCount);
        for (int i = 0; i < repeatCount; i++) {
            assertThat(snapShot.getSnapShot(i)).isEqualTo(list.get(i));
        }
    }

    private static List<CarDto> carDtos(int... positions) {
        ArrayList<CarDto> result = new ArrayList<>();
        for (int position : positions) {
            result.add(new CarDto(position));
        }
        return result;
    }

}
