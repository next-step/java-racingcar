package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RacingGameTest {
    private static final int DEFAULT_CAR_COUNT = 3;
    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame(DEFAULT_CAR_COUNT);
    }

    @Test
    public void 기본게임_자동차_대수_3대() {
        assertThat(racingGame.getCars().size()).isEqualTo(3);
    }

    @Test
    public void 새게임생성_자동차_대수_5대() {
        racingGame = new RacingGame(5);
        assertThat(racingGame.getCars().size()).isEqualTo(5);
    }

    @Test
    public void 랜덤값이_4이상이면_자동차_전진() {
        Car car = racingGame.getCars().get(0);

        assertThat(racingGame.run(car, 4)).isEqualTo(true);
        assertThat(racingGame.run(car, 5)).isEqualTo(true);
        assertThat(racingGame.run(car, 6)).isEqualTo(true);
        assertThat(racingGame.run(car, 7)).isEqualTo(true);
        assertThat(racingGame.run(car, 8)).isEqualTo(true);
        assertThat(racingGame.run(car, 9)).isEqualTo(true);
    }

    @Test
    public void 랜덤값이_4이하면_자동차_전진_안함() {
        Car car = racingGame.getCars().get(0);

        assertThat(racingGame.run(car, 3)).isEqualTo(false);
        assertThat(racingGame.run(car, 2)).isEqualTo(false);
        assertThat(racingGame.run(car, 1)).isEqualTo(false);
        assertThat(racingGame.run(car, 0)).isEqualTo(false);
    }

    @Test
    public void 전진안한_자동차_레이싱_결과_확인() {
        Car car = racingGame.getCars().get(0);

        racingGame.run(car, 0);

        System.out.println("출발지는 | 로 표시");
        assertThat(racingGame.printRaceResult(car)).isEqualTo("|");
    }

    @Test
    public void 세칸_전진후_레이싱_결과_확인() {
        Car car = racingGame.getCars().get(1);

        racingGame.run(car, 6);
        racingGame.run(car, 7);
        racingGame.run(car, 8);

        System.out.println("출발지는 | 로 표시");
        assertThat(racingGame.printRaceResult(car)).isEqualTo("|---");
    }
}
