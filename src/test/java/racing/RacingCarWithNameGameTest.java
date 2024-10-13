package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarWithNameGameTest {

    @Test
    @DisplayName("자동차 이름이 5글자를 초과할 경우 예외를 발생한다")
    void testCarNameOverFiveLetters() {
        assertThatThrownBy(() -> {
            RacingCarWithNameGame.start("pobi,crong,honux1", 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름과 상태를 화면에 출력한다. 자동차 전진 횟수는 '-' 의 개수와 같다")
    void testDisplayResultWithCarName() {
        RacingCar racingCar = new RacingCar("pobi", new Operator(1L));
        for (int i = 0; i < 10; i++) {
            racingCar.race();
        }
        String result = ResultView.display(new RacingCar[]{racingCar});
        assertThat(result).isEqualTo("pobi : ---------\n\n");
    }

    @Test
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다")
    void testFindWinners() {
        RacingCar pobiRacingCar = new RacingCar("pobi", new Operator(1L));
        RacingCar crongRacingCar = new RacingCar("crong", new Operator(2L));
        RacingCar honuxRacingCar = new RacingCar("honux", new Operator(1L));

        RacingCars racingCars = new RacingCars(new RacingCar[]{pobiRacingCar, crongRacingCar, honuxRacingCar});
        for (int i = 0; i < 10; i++) {
            racingCars.racing();
        }

        List<RacingCar> winners = racingCars.findWinners();
        String result = ResultView.displayWinners(winners);
        assertThat(result).isEqualTo("pobi, honux가 최종 우승했습니다.");
    }
}
