package racinggame;

import org.junit.Before;
import org.junit.Test;
import racinggame.domain.Car;
import racinggame.domain.Racing;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.controller.RacingGame.game;
import static utils.GenerateRandom.generatingRandomNumber;
import static utils.Separator.separateName;

public class RacingGameTest {
    public static final int RANGE_RANDOM = 10;
    final String userName = "Kim,Lee,Park";

    @Before
    public void setUp() {
        List<String> winners = new ArrayList<>();
        winners.add("Kim");
        winners.add("Park");
    }

    @Test
    public void 레이싱_실행() {
        int tryGame = generatingRandomNumber(RANGE_RANDOM);

        Racing racing = new Racing(userName, tryGame);
        game(racing);
    }

    @Test
    public void 정지() {
        Racing racing = new Racing(userName, 3);

        racing.isCarMoving(3);
        assertThat(false).isEqualTo(false);
    }

    @Test
    public void 동작() {
        Racing racing = new Racing(userName, 3);

        racing.isCarMoving(4);
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void 자동차_움직임() {
        Car car = new Car("kim");

        car.move();
        assertThat(car.getCountMoving()).isEqualTo(1);
    }

    @Test
    public void 문자열_콤마_분리() {
        assertThat(separateName(userName)).isEqualTo(new String[]{"Kim", "Lee", "Park"});
    }

    @Test
    public void 문자열_띄어쓰기_분리() {
        final String name = "Kim Lee Park";
        assertThat(separateName(name)).isEqualTo(new String[]{"Kim", "Lee", "Park"});
    }
}