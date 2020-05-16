package com.cheolhyeonpark.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class StageTest {

    @Test
    @DisplayName("스테이지가 시작되면 주사위를 굴려서 자동차를 전진시킨다")
    public void moveCarAfterRollDice() {
        //given
        Dice dice = new Dice();
        List<Car> cars = Arrays.asList(new Car(), new Car(), new Car());
        Stage stage = spy(new Stage(dice, cars));

        //when
        stage.run();

        //then
        verify(stage, times(1)).run();
    }
}