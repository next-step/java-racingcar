package step3.domain.gameStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class RandomCarGameStrategyTest {

    RandomCarGameStrategy randomCarGameStrategy = new RandomCarGameStrategy();


    @DisplayName("4이상의 수를 입력하면 1을 리턴한다.")
    @ParameterizedTest()
    @ValueSource(ints = {4, 5})
    void getGameResult(int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = RandomCarGameStrategy.class.getDeclaredMethod("getGameResult", int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(randomCarGameStrategy, value);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("4미만의 수를 입력하면 0을 리턴한다.")
    @ParameterizedTest()
    @ValueSource(ints = {3, 2})
    void getGameResult2(int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = RandomCarGameStrategy.class.getDeclaredMethod("getGameResult", int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(randomCarGameStrategy, value);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("게임결과 항상 1 또는 0의 값을 리턴한다.")
    @Test
    void getDistanceToMove() {
        int distanceToMove = randomCarGameStrategy.getDistanceToMove();
        assertThat(isZeroOrOne(distanceToMove)).isEqualTo(true);
    }

    boolean isZeroOrOne(int value) {
        return value == 1 || value == 0;
    }
}