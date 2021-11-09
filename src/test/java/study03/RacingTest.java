package study03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    @DisplayName("Racing 객체 생성 시 게임횟수 확인")
    void 횟수() throws NoSuchFieldException, IllegalAccessException {
        int expect = 3;

        Racing racing = new Racing(3, expect);
        Field tryCount = Racing.class.getDeclaredField("tryCount");
        tryCount.setAccessible(true);
        Integer inputTryCount = (Integer) tryCount.get(racing);

        assertThat(inputTryCount).isEqualTo(expect);
    }

    @Test
    @DisplayName("Racing 객체 생성 시 자동차 생성 확인")
    void 자동차갯수() throws NoSuchFieldException, IllegalAccessException {
        Racing racing = new Racing(3, 3);
        Field tryCount = Racing.class.getDeclaredField("carFactory");
        tryCount.setAccessible(true);
        CarFactory inputCarCount = (CarFactory) tryCount.get(racing);

        assertThat(inputCarCount).isNotNull();
    }

    @Test
    void sdf() {
        Racing racing = new Racing(3, 10);
        racing.run();
    }

}