package racingcar.domain;

import org.junit.Before;
import org.junit.Test;
import racingcar.utils.RandomGeneratorImpl;
import racingcar.view.OutputView;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RacingGameTest {
    private static final int MAX_RANGE = 10;
    private RacingGame racingGame;
    private String[] names;

    @Before
    public void setUp() throws Exception {
        names = "pobi,crong,honux".split(",");
    }

    @Test
    public void 자동차생성_테스트() {
        racingGame = new RacingGame(names, new RandomGeneratorImpl(MAX_RANGE));
        assertThat(racingGame.getCars().size()).isEqualTo(names.length);
    }

    @Test
    public void 랜덤값_4이상이면_전진_한칸() {
        racingGame = new RacingGame(names, new TestRandomGenerator(6));
        Car car = racingGame.getCars().get(0);

        racingGame.run(car);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 두칸_전진_후_포지션_확인() {
        racingGame = new RacingGame(names, new TestRandomGenerator(6));
        Car car = racingGame.getCars().get(0);

        racingGame.run(car);
        racingGame.run(car);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    public void 랜덤값_4이하면_전진안함() {
        racingGame = new RacingGame(names, new RandomGeneratorImpl(4));
        Car car = racingGame.getCars().get(0);

        racingGame.run(car);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
