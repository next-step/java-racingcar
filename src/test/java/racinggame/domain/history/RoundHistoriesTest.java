package racinggame.domain.history;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racinggame.domain.car.Car;

class RoundHistoriesTest {

    @Test
    void 승자_찾기_테스트_슺자가_한명() {
        RoundHistories roundHistories = new RoundHistories();
        List<Car> cars = Arrays.asList(new Car("a", 3), new Car("b", 5));
        roundHistories.captureRoundHistory(cars);
        System.out.println(roundHistories.findWinners().getWinners().get(0).getWinnerName());
        Assertions.assertThat(roundHistories.findWinners().getWinners().size()).isEqualTo(1);
    }

    @Test
    void 승자_찾기_테스트_슺자가_두명이상() {
        RoundHistories roundHistories = new RoundHistories();
        List<Car> cars = Arrays.asList(new Car("a", 3), new Car("b", 5), new Car("h", 5));
        roundHistories.captureRoundHistory(cars);
        System.out.println(roundHistories.findWinners().getWinners().get(0).getWinnerName());
        Assertions.assertThat(roundHistories.findWinners().getWinners().size()).isEqualTo(2);
    }

}
