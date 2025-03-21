package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class RoundTest {
    static final Dice luckyDice = new LuckyDice();

    @Test
    @DisplayName("라운드를 play하면 해당 라운드가 종료된다")
    void finishRoundTest() {
        // given
        var round = new Round(luckyDice);
        List<Car> testCars = Collections.emptyList();

        // when
        round.play(testCars);

        // then
        Assertions.assertThat(round.isFinished()).isTrue();
    }

    @Test
    @DisplayName("종료된 라운드는 play를 할 수 없다.")
    void playFinishedRoundTest() {
        // given
        var round = new Round(luckyDice);
        List<Car> testCars = Collections.emptyList();
        round.play(testCars);

        // when & then
        Assertions.assertThatThrownBy(() -> round.play(testCars))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 종료된 라운드입니다.");
    }

    @Test
    @DisplayName("라운드를 play하면 전달 받은 자동차들의 주사위를 굴린다")
    void playTest() {
        // given
        var car1 = new Car("");
        var car2 = new Car("");
        var car3 = new Car("");
        var cars = List.of(car1, car2, car3);
        // 항상 성공하는 주사위
        var playTimes = 3;
        var rounds = List.of(new Round(luckyDice), new Round(luckyDice), new Round(luckyDice));

        // when
        rounds.forEach(round -> round.play(cars));

        // then
        Assertions.assertThat(car1.getPosition()).isEqualTo(playTimes);
        Assertions.assertThat(car2.getPosition()).isEqualTo(playTimes);
        Assertions.assertThat(car3.getPosition()).isEqualTo(playTimes);
    }
}
