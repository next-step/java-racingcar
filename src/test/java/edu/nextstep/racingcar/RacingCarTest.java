package edu.nextstep.racingcar;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarTest {

    @Test
    @DisplayName("자동차 경주 참여 RacingCarList 생성 test")
    void createCarListTest() {
        //given
        int carNum = 3;

        // when
        Cars racingCarList = RacingCar.createCarList(3);

        // then
        assertThat(racingCarList.size()).isEqualTo(carNum);
    }

    /*
     * RacingCar.move() Test *
     * 해당 메서드의 경우 Random 값에 따라 동작이 달라지므로
     * 세부 동작들을 private 메서드로 정의 후 메서드 내부를 Test 에 구현하여 진행
     */
    @Test
    @DisplayName("Random 값 적용하여 RacingCar 의 movedDistance 변경 되는지 확인")
    void moveTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        // given
        RacingCar racingCar = new RacingCar();
        Method getRandomNum = racingCar.getClass().getDeclaredMethod("getRandomNum");
        getRandomNum.setAccessible(true);
        Method moveRacingCar = racingCar.getClass().getDeclaredMethod("moveRacingCar");
        moveRacingCar.setAccessible(true);

        // when
        int randomNum = -1;
        while (randomNum < 4) {
            randomNum = (int) getRandomNum.invoke(racingCar);
        }
        moveRacingCar.invoke(racingCar);

        // then
        assertThat(racingCar.getMovedDistance()).isEqualTo(1);
    }

}