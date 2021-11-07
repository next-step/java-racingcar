package study03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @DisplayName("Racing 객체 생성 시 인스턴스변수 생성확인")
    @ParameterizedTest(name="{index} {displayName} param={0}")
    @CsvSource(value = {"5: 1", "2: 3", "10: 13"}, delimiter = ':')
    void 생성자(String cars, String trycnt) throws NoSuchFieldException, IllegalAccessException {
        Racing racing = new Racing(cars, trycnt);

        Field carList = Racing.class.getDeclaredField("cars");
        carList.setAccessible(true);
        LinkedList<Car> carLinkedList = (LinkedList<Car>) carList.get(racing);
        assertThat(carLinkedList.size()).isEqualTo(Integer.parseInt(cars));

        Field tryCount = Racing.class.getDeclaredField("tryCount");
        tryCount.setAccessible(true);
        Integer inputTryCount = (Integer) tryCount.get(racing);
        assertThat(inputTryCount).isEqualTo(Integer.parseInt(trycnt));
    }

    @Test
    void 게임시작() {
        Racing racing = new Racing("3", "3");
        racing.start();
    }

}