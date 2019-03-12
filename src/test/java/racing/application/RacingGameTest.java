package racing.application;

import org.junit.Test;
import racing.infrastructure.RandomCondition;
import racing.view.RacingRequestView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RacingGameTest {

    @Test
    public void 랜덤함수() {
        //given
        int expected = 3;
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return expected;
            }
        };

        //when
        int actual = random.nextInt(9);

        //then
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void 한명이_게임_한번_실행() {
        //given
        RacingRequestView requestView = new RacingRequestView("차", 3);
        RandomCondition condition = mock(RandomCondition.class);
        RacingGame racingGame = new RacingGame(requestView, condition);
        when(condition.check()).thenReturn(true);

        //when
        racingGame.start();

        //then
        assertThat(racingGame.getViews().getPositions().get(0)).isEqualTo(4);
    }

    @Test
    public void 승자확인() {
        //given
        RacingRequestView requestView = new RacingRequestView("pobi,crong,honux", 3);
        RandomCondition condition = mock(RandomCondition.class);

        List<Car> cars = new ArrayList();
        Car car = mock(Car.class);
        cars.add(car);
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));
        RacingGame racingGame = new RacingGame(requestView, condition);
        when(car.getName()).thenReturn("pobi");
        when(car.getPosition()).thenReturn(5);

        //when
        List<Car> sorted = racingGame.sortByPosition(cars);

        //then
        assertThat(sorted.get(0).getName()).isEqualTo("pobi");
    }
}