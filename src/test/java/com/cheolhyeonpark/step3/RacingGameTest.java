package com.cheolhyeonpark.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
        int numberOfCars = 3;
        RacingGame racingGame = new RacingGame(numberOfCars, 0);

        //when
        List<Car> cars = racingGame.getResultOfStage();

        //then
        assertThat(cars.size()).isEqualTo(numberOfCars);
    }

    @Test
    @DisplayName("입력받은만큼 스테이지가 실행된다")
    public void runStage() {
        //given
        RacingGame racingGame = spy(new RacingGame(3, 5));

        //when
        racingGame.playStage();

        //then
        verify(racingGame, times(1)).playStage();
    }

    @Test
    @DisplayName("스테이지가 남아있는지 검사한다.")
    public void checkStageLeft() {
        //given
        RacingGame racingGame = new RacingGame(3, 1);
        boolean hasStageLeftBeforePlay = racingGame.hasNextStage();

        //when
        racingGame.playStage();
        boolean hasStageLeftAfterPlay = racingGame.hasNextStage();

        //then
        assertThat(hasStageLeftBeforePlay).isTrue();
        assertThat(hasStageLeftAfterPlay).isFalse();
    }
}