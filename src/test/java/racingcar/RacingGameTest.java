package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("Racing Game 은 시작되고 난후에 결과를 반환한다")
    @Test
    void makeGame() {
        RacingGame racingGame = new RacingGame(5, 3);

        List<List<Integer>> result = racingGame.run();

        List<Integer> record = result.get(0);

        assertThat(record.get(0)).isEqualTo(1);
        assertThat(record.get(1)).isEqualTo(2);
        assertThat(record.get(2)).isEqualTo(3);
        assertThat(record.get(3)).isEqualTo(4);
        assertThat(record.get(4)).isEqualTo(5);
    }

    @DisplayName("Car 의 이동 여부를 결정지을 객체는 항상 9를 반환한다.")
    @Test
    void generateNumberNine() {
        Engine engine = new Engine();

        assertThat(engine.generateNumber()).isEqualTo(9);
        assertThat(engine.generateNumber()).isEqualTo(9);
        assertThat(engine.generateNumber()).isEqualTo(9);
    }
}