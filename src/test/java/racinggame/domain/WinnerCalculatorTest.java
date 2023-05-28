package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.MovableMoveStrategy;
import racinggame.domain.Name;
import racinggame.domain.WinnerCalculator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCalculatorTest {
    @Test
    @DisplayName("우승자 계산 - 1명")
    void calculateWinnerTest_OneWinner() {
        // given
        Car boong = new Car(new Name("boong"));
        Car pobi = new Car(new Name("pobi"));
        pobi.move(new MovableMoveStrategy());

        List<Car> cars = Arrays.asList(boong, pobi);

        // when
        List<Car> winners = WinnerCalculator.getWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo(new Name("pobi"));
    }

    @Test
    @DisplayName("우승자 계산 - 2명 이상")
    void calculateWinnerTest_MultipleWinner() {
        // given
        Car pobi = new Car(new Name("pobi"));
        Car boo = new Car(new Name("boo"));
        boo.move(new MovableMoveStrategy());
        Car rung = new Car(new Name("rung"));
        rung.move(new MovableMoveStrategy());

        List<Car> cars = Arrays.asList(pobi, boo, rung);

        // when
        List<Car> winners = WinnerCalculator.getWinners(cars);

        // then
        assertThat(winners).hasSize(2);
    }
}
