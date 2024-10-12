package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.dto.CarDto;
import racinggame.dto.History;
import racinggame.generator.TestNumberGenerator;

public class RacingGameTest {


    @Test
    public void 이동횟수만큼_이동_테스트() {
        int repeat = 4;

        RacingGame racingGame = new RacingGame(repeat, 4);
        History result = racingGame.start(new TestNumberGenerator(4));

        assertThat(result.getSnapShot(result.repeatCount() - 1)).isEqualTo(
                carDtos(repeat + 1, repeat + 1, repeat + 1, repeat + 1));
    }

    @Test
    public void 이동_횟수_음수_테스트() {
        assertThatThrownBy(() -> new RacingGame(0, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("반복횟수는 1이상이여야 합니다.");
    }

    private static List<CarDto> carDtos(int... positions) {
        ArrayList<CarDto> result = new ArrayList<>();
        for (int position : positions) {
            result.add(new CarDto(position));
        }
        return result;
    }


}
