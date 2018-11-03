package racing.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    TestNumberProvider testNumberProvider = new TestNumberProvider();

    @Before
    public void setup() {
        RacingCar.RANDOM_PROVIDER = testNumberProvider;
    }

    @Test
    public void 레이싱_테스트() {
        RacingGame racingGame = new RacingGame(3, 3);
        testNumberProvider.setTestNumber(4);
        assertThat(racingGame.race())
                .isEqualTo(Arrays.asList(1, 1, 1));

        testNumberProvider.setTestNumber(5);
        assertThat(racingGame.race())
                .isEqualTo(Arrays.asList(2, 2, 2));

        testNumberProvider.setTestNumber(3);
        assertThat(racingGame.race())
                .isEqualTo(Arrays.asList(2, 2, 2));
    }

    @Test
    public void 레이싱_횟수_제한_확인() {
        // 총 race는 2회 가능하도록 설정
        RacingGame racingGame = new RacingGame(1, 2);
        assertThat(racingGame.isRacingAvailable()).isTrue();

        // 1회 race를 하더라도 다음 레이스는 가능
        racingGame.race();
        assertThat(racingGame.isRacingAvailable()).isTrue();

        // 2회 레이스 후 레이스는 더이상 불가능
        racingGame.race();
        assertThat(racingGame.isRacingAvailable()).isFalse();


    }
}