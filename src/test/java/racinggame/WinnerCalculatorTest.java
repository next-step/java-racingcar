package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.MovableMoveStrategy;
import racinggame.domain.WinnerCalculator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinnerCalculatorTest {
    @Test
    @DisplayName("우승자 계산 - 1명")
    void calculateWinnerTest_OneWinner() {
        // given
        Car boong = new Car("boong");
        Car pobi = new Car("pobi");
        pobi.move(new MovableMoveStrategy());

        List<Car> cars = Arrays.asList(boong, pobi);

        // when
        List<Car> winners = WinnerCalculator.getWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("우승자 계산 - 2명 이상")
    void calculateWinnerTest_MultipleWinner() {
        // given
        Car pobi = new Car("pobi");
        Car boo = new Car("boo");
        boo.move(new MovableMoveStrategy());
        Car rung = new Car("rung");
        rung.move(new MovableMoveStrategy());

        List<Car> cars = Arrays.asList(pobi, boo, rung);

        // when
        List<Car> winners = WinnerCalculator.getWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(2);
    }
}
