package newcarracing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    @Test
    void 자동차_위치_출력() {
        RacingCar racingCar = new RacingCar("pobi", 5);
        assertThat(racingCar.createRacingCarRoute(racingCar)).isEqualTo("pobi : -----") ;
    }

    @Test
    void 우승자_출력() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("pobi"));
        cars.add(new RacingCar("honux"));
        assertThat(ResultView.createCommentForPrintingWinners(cars)).isEqualTo("pobi, honux가 최종 우승했습니다.");
    }
}