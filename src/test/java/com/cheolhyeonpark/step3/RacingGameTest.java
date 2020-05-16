package com.cheolhyeonpark.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @Test
    @DisplayName("입렫받은 차의 대수 만큼 Car객체를 생성해야한다")
    public void getCars() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        int numberOfCars = 3;
        Method method = racingGame.getClass().getDeclaredMethod("getCars", int.class);
        method.setAccessible(true);

        //when
        List<Car> cars = (List<Car>) method.invoke(racingGame, numberOfCars);

        //then
        assertThat(cars.size()).isEqualTo(numberOfCars);
    }
}