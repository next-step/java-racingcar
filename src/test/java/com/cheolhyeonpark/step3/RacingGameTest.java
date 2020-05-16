package com.cheolhyeonpark.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RacingGameTest {

    @Test
    @DisplayName("스테이지 객체를 생성한다")
    public void generateStage() throws NoSuchFieldException {
        //given
        RacingGame racingGame = new RacingGame(3, 5);

        //given
        Field field = racingGame.getClass().getDeclaredField("stage");
        field.setAccessible(true);

        //then
        assertThat(field.getType()).isEqualTo(Stage.class);
    }

    @Test
    @DisplayName("입렫받은 차의 대수 만큼 Car객체를 생성해야한다")
    public void getCars() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        RacingGame racingGame = new RacingGame(0, 0);
        int numberOfCars = 3;
        Method method = racingGame.getClass().getDeclaredMethod("getCars", int.class);
        method.setAccessible(true);

        //when
        List<Car> cars = (List<Car>) method.invoke(racingGame, numberOfCars);

        //then
        assertThat(cars.size()).isEqualTo(numberOfCars);
    }

    @Test
    @DisplayName("입력받은만큼 스테이지가 실행된다")
    public void runStage() throws NoSuchMethodException {
        //given
        RacingGame racingGame = spy(new RacingGame(3, 5));

        //when
        racingGame.play();

        //then
        verify(racingGame, times(1)).play();
    }
}