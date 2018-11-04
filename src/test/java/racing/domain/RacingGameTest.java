package racing.domain;

import org.junit.Before;
import org.junit.Test;
import racing.dto.RacingCarStatus;
import racing.dto.RacingGameCreateRequest;
import racing.testutil.TestNumberProvider;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

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
        List<RacingCarStatus> race = racingGame.race();
        assertThat(race).extracting("name", "position")
                .containsSequence(tuple("a", 1), tuple("b", 1), tuple("c", 1));
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

    @Test
    public void 승리자_찾기() {
        RacingGameCreateRequest request = new RacingGameCreateRequest(asList("a, b,c"), 0);
        RacingGame racingGame = new RacingGame(request);

        // 테스트를 위해서 접근제한자를 제거하는건 옳은 판단일까??
        // b와 c를 공동우승으로 설정하자!
        List<RacingCar> internalRacingCars = racingGame.racingCars;
        internalRacingCars.get(1).setPosition(3);
        internalRacingCars.get(2).setPosition(3);

        List<String> winnerNames = racingGame.getWinner();

        assertThat(winnerNames).containsExactly("b", "c");
    }
}