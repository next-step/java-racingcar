package step3;

import step3.car.Car;
import step3.factory.RacingCarFactory;
import step3.game.RacingGame;
import step3.game.RacingGameImpl;
import step3.game.RacingInfomation;
import step3.view.ResultView;

import java.util.*;

public class TestRacingGame extends RacingGameImpl {
    private Queue<Integer> numbers = new LinkedList<>();

    public void updateNumbers(List<Integer> input) {
        input.forEach(numbers::offer);
    }

    @Override
    public Integer getNumber() {
        return numbers.poll();
    }
}
