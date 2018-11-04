package racing.domain;

import org.junit.Before;
import org.junit.Test;
import racing.dto.RacingGameCreateRequest;
import racing.testutil.TestNumberProvider;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    TestNumberProvider testNumberProvider = new TestNumberProvider();

    @Before
    public void setup() {
        RacingCar.RANDOM_PROVIDER = testNumberProvider;
    }

    @Test
    public void 레이싱_테스트() {
        RacingGameCreateRequest request = new RacingGameCreateRequest(asList("a", "b", "c"), 3);
        RacingGame racingGame = new RacingGame(request);

        testNumberProvider.setTestNumber(RacingCar.MOVE_BOUND_VALUE);

        // 전진 결과가 리스트와 맞는지 확인한다.
        assertThat(racingGame.race())
                .isEqualTo(asList(1, 1, 1));
    }

    @Test
    public void 레이싱_횟수_제한_확인() {
        // 총 race는 2회 가능하도록 설정
        RacingGameCreateRequest request = new RacingGameCreateRequest(asList("a"), 2);
        RacingGame racingGame = new RacingGame(request);

        // 기본값은 0이 설정됨
        assertThat(racingGame.isRacingAvailable()).isTrue();

        // 1회 race를 하더라도 다음 레이스는 가능
        racingGame.race();
        assertThat(racingGame.isRacingAvailable()).isTrue();

        // 2회 레이스 후 레이스는 더이상 불가능
        racingGame.race();
        assertThat(racingGame.isRacingAvailable()).isFalse();
    }
}