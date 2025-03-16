package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class RoundTest {

    @Test
    @DisplayName("라운드를 play하면 해당 라운드가 종료된다")
    void finishRoundTest() {
        // given
        var round = new Round(new Random());

        // when
        round.play(List.of());

        // then
        Assertions.assertThat(round.isFinished()).isTrue();
    }

    @Test
    @DisplayName("라운드를 play하면 전달 받은 자동차들의 주사위를 굴린다")
    void playTest() {
        // given
        var car1 = new Car();
        var car2 = new Car();
        var car3 = new Car();
        var cars = List.of(car1, car2, car3);
        // 항상 성공하는 주사위
        var luckyDice = new DiceTest.MockRandom(Car.MOVE_THRESHOLD + 1);
        var round = new Round(luckyDice);
        var playTimes = 3;

        // when
        for (int i = 0; i < playTimes; i++) {
            round.play(cars);
        }

        // then
        Assertions.assertThat(car1.getPosition()).isEqualTo(playTimes);
        Assertions.assertThat(car2.getPosition()).isEqualTo(playTimes);
        Assertions.assertThat(car3.getPosition()).isEqualTo(playTimes);
    }
}
