package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RacingGameTest {
    private static final int MAX_RANGE = 10;
    private RacingGame racingGame;

    @Test
    public void 자동차생성_테스트() {
        racingGame = new RacingGame(5, new RandomGeneratorImpl(MAX_RANGE));
        assertThat(racingGame.getCars().size()).isEqualTo(5);
    }

    @Test
    public void 랜덤값_4이상이면_전진_한칸() {
        racingGame = new RacingGame(5, new TestRandomGenerator(6));
        Car car = racingGame.getCars().get(0);

        racingGame.run(car);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 두칸_전진_후_포지션_확인() {
        racingGame = new RacingGame(5, new TestRandomGenerator(6));
        Car car = racingGame.getCars().get(0);

        racingGame.run(car);
        racingGame.run(car);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void 랜덤값_4이하면_전진안함() {
        racingGame = new RacingGame(5, new RandomGeneratorImpl(4));
        Car car = racingGame.getCars().get(0);

        racingGame.run(car);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 전진안한_자동차_레이싱_결과_확인() {
        racingGame = new RacingGame(3, new RandomGeneratorImpl(4));
        Car car = racingGame.getCars().get(0);

        racingGame.run(car);

        System.out.println("출발지는 | 로 표시");
        assertThat(racingGame.generateRaceResultString(car)).isEqualTo("|");
    }

    @Test
    public void 세칸_전진후_레이싱_결과_확인() {
        racingGame = new RacingGame(3, new TestRandomGenerator(10));
        Car car = racingGame.getCars().get(1);

        racingGame.run(car);
        racingGame.run(car);
        racingGame.run(car);

        System.out.println("출발지는 | 로 표시");
        assertThat(racingGame.generateRaceResultString(car)).isEqualTo("|---");
    }
}
