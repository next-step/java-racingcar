package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.MinimumRule;
import racingcar.util.BasicNumberGenerator;
import racingcar.view.CountView;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    /*
    --------------------------------------------------------------------------------
    - 단위 테스트
    --------------------------------------------------------------------------------
     */


    @Test
    @DisplayName("게임 상태 관리 - 자동차 수, 경기 회수를 저장 한다")
    void racing_car_and_race_count() {
        RacingCarGame racingCarGame = new RacingCarGame(
                new CountView(3, 5),
                new ResultView(),
                new MinimumRule(4, new BasicNumberGenerator(9))
        );

        racingCarGame.start();

        assertThat(racingCarGame.carCount()).isEqualTo(3);
        assertThat(racingCarGame.raceCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 생성 - 입력한 수만큼 자동차를 생성한다.")
    void create_car_count() {
        RacingCarGame racingCarGame = new RacingCarGame(
                new CountView(3, 5),
                new ResultView(),
                new MinimumRule(4, new BasicNumberGenerator(9))
        );

        racingCarGame.start();

        assertThat(racingCarGame.cars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("경기 생성 - 입력한 수만큼 경기를 생성한다.")
    void create_race_count() {
        RacingCarGame racingCarGame = new RacingCarGame(
                new CountView(3, 5),
                new ResultView(),
                new MinimumRule(4, new BasicNumberGenerator(9))
        );

        racingCarGame.start();

        assertThat(racingCarGame.races().size()).isEqualTo(5);
    }

    /*
    ----------------------------------------------------------------------------
    - 통합 테스트
    ----------------------------------------------------------------------------
    */

    @Test
    @DisplayName("경기를 시작하면 (자동차 수 * 경기 수) 만큼의 경기 기록을 생성 한다. ")
    void race_start() {

        int carCount = 3;
        int raceCount = 5;

        RacingCarGame racingCarGame = new RacingCarGame(
                new CountView(carCount, raceCount),
                new ResultView(),
                new MinimumRule(4, new BasicNumberGenerator(9))
        );

        racingCarGame.start();
        int count = racingCarGame.races()
                .stream()
                .map(race -> race.raceRecords().list().size())
                .mapToInt(Integer::valueOf)
                .sum();

        assertThat(count).isEqualTo(carCount * raceCount);
    }
}