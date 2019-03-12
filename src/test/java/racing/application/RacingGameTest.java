package racing.application;

import org.junit.Test;
import racing.view.RacingRequestView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


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
        RacingGame game = new RacingGame(requestView, new TrueCondition());

        //when
        game.start();

        //then
        assertThat(game.getViews().getPositions().get(0)).isEqualTo(4);
    }

    @Test
    public void 승자확인() {
        //given
        RacingRequestView requestView = new RacingRequestView("pobi,crong,honux", 3);
        RacingGame game = new RacingGame(requestView, new TrueCondition());

        List<Car> cars = new ArrayList();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));

        //when
        List<String> sorted = game.getResult();

        //then
        assertThat(sorted.get(0)).isEqualTo("pobi");
    }
}

class TrueCondition implements Condition {
    @Override
    public boolean check() {
        return true;
    }
}