package racing.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racing.application.view.Score;
import racing.domain.car.Car;
import racing.domain.car.CarRace;

class RacingServiceTest {

    @Test
    void 자동차를_입력한_개수만큼_생성한다() {
        //given
        int count = 3;
        RacingService racingService = new RacingServiceImpl();

        //when
        CarRace carRace = racingService.makeCars(count);

        //then
        assertThat(carRace.size()).isEqualTo(count);
    }

    @Test
    void 자동차가_움직이고_점수를_반환한다() {
        //given
        int count = 3;
        RacingService racingService = new RacingServiceImpl();
        CarRace carRace = new CarRace(List.of(new Car()));

        //when
        Score score = racingService.scoreBoard(carRace, count);

        //then
        assertThat(score.size()).isEqualTo(count);
    }
}