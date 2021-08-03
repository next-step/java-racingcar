package edu.nextstep.racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class RandomStrategyTest {

    @Test
    @DisplayName("Random 값 범위 이내 숫자만 출력하는지 확인")
    void canMoveTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        RandomStrategy randomStrategy = new RandomStrategy();
        Method getRandomNum = randomStrategy.getClass().getDeclaredMethod("getRandomNum");
        getRandomNum.setAccessible(true);

        // when
        boolean check = true;
        int i = 0;
        while (i < 100 && check == true) {
            int num = (int) getRandomNum.invoke(randomStrategy);
            check = (0 <= num && num <= 10);
            i++;
        }

        // then
        assertThat(check).isEqualTo(true);
    }
}