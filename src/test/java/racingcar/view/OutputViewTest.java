package racingcar.view;

import org.junit.Before;
import org.junit.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.TestRandomGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OutputViewTest {
    private List<String> names;

    @Before
    public void setUp() throws Exception {
        names = Arrays.asList("pobi,crong,honux".split(","));
    }

    @Test
    public void 전진안한_자동차_레이싱_결과_확인() {
        RacingGame racingGame = new RacingGame(names, new TestRandomGenerator(3));
        Car car = racingGame.getCars().get(0);

        racingGame.run(car);

        assertThat(OutputView.generateRaceResultString(car)).isEqualTo(car.getName() + " : ");
    }

    @Test
    public void 세칸_전진후_레이싱_결과_확인() {
        RacingGame racingGame = new RacingGame(names, new TestRandomGenerator(10));
        Car car = racingGame.getCars().get(1);

        racingGame.run(car);
        racingGame.run(car);
        racingGame.run(car);

        assertThat(OutputView.generateRaceResultString(car)).isEqualTo(car.getName() + " : ---");
    }

    @Test
    public void 단독_우승자_결과_확인() {
        RacingGame racingGame = new RacingGame(names, new TestRandomGenerator(10));
        Car car = racingGame.getCars().get(0);
        car.addPosition();
        car.addPosition();

        assertThat(OutputView.generateWinnersString(racingGame.getCars())).isEqualTo("pobi가 최종 우승했습니다.");
    }

    @Test
    public void 복수_우승자_결과_확인() {
        RacingGame racingGame = new RacingGame(names, new TestRandomGenerator(10));
        Car car1 = racingGame.getCars().get(0);
        car1.addPosition();
        car1.addPosition();

        Car car2 = racingGame.getCars().get(1);
        car2.addPosition();
        car2.addPosition();

        assertThat(OutputView.generateWinnersString(racingGame.getCars())).isEqualTo("pobi, crong가 최종 우승했습니다.");
    }
}
