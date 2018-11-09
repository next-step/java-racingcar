package racingGame.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;

    @Before
    public void setUp() {
        racingCar = new RacingCar("test");
    }

    @Test
    public void 초기_위치체크() {
        racingCar = new RacingCar("test");

        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    public void 한번_이동후_위치체크() {
        racingCar = new RacingCar("test");
        racingCar.move(5);

        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    public void 이동불가능한_조건체크() {
        assertThat(racingCar.isMovable(3)).isEqualTo(false);
    }

    @Test
    public void 자동_이동후_위치체크() {
        List<Integer> moveConditions = new ArrayList<>(Arrays.asList(1, 4, 5, 7, 4, 1, 3));

        for (int moveCondition : moveConditions) {
            racingCar.move(moveCondition);
        }

        assertThat(racingCar.getPosition()).isEqualTo(4);
    }
}