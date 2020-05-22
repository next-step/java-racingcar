package com.cheolhyeonpark.step4;

import com.cheolhyeonpark.step4.domain.Car;
import com.cheolhyeonpark.step4.domain.Dice;
import com.cheolhyeonpark.step4.domain.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class StageTest {

    @Test
    @DisplayName("스테이지가 시작되면 주사위를 굴려서 자동차를 전진시킨다")
    public void moveCarAfterRollDice() {
        //given
        Dice dice = mock(Dice.class);
        when(dice.rollDice()).thenReturn(Stage.MINIMUM_MOVABLE_DICE_NUMBER);
        List<Car> cars = Arrays.asList(new Car("t1", 0), new Car("t2", 0), new Car("t3", 0));
        Stage stage = new Stage(dice, cars);

        //when
        stage.run();

        //then
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("주사위 숫자가 기준보다 낮으면 자동차는 정지해 있다")
    public void stopCarAfterRollDice() {
        //given
        Dice dice = mock(Dice.class);
        when(dice.rollDice()).thenReturn(Stage.MINIMUM_MOVABLE_DICE_NUMBER - 1);
        List<Car> cars = Arrays.asList(new Car("t1", 0), new Car("t2", 0), new Car("t3", 0));
        Stage stage = new Stage(dice, cars);

        //when
        stage.run();

        //then
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("가장 많이 전진한 차가 승리차량이 된다")
    public void getWinners() {
        //given
        Dice dice = new Dice();
        Car car1 = new Car("t1", 10);
        Car car2 = new Car("t2", 5);
        Car car3 = new Car("t3", 1);
        List<Car> cars = Arrays.asList(car1, car2, car3);
        Stage stage = new Stage(dice, cars);

        //when
        List<Car> winners = stage.getWinners();

        //then
        assertThat(winners.get(0)).isEqualTo(car1);
    }
}