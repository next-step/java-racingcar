package study03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @DisplayName("Racing 객체 생성 시 car 갯수 확인")
    @ParameterizedTest(name = "{index} {displayName} param={0}")
    @CsvSource(value = {"5:1", "2:3", "10:13"}, delimiter = ':')
    void constructorWithCars(String cars, String trycnt) throws NoSuchFieldException, IllegalAccessException {
        Racing racing = new Racing(cars, trycnt);
        Field carList = Racing.class.getDeclaredField("cars");
        carList.setAccessible(true);
        LinkedList<Car> carLinkedList = (LinkedList<Car>) carList.get(racing);
        assertThat(carLinkedList.size()).isEqualTo(Integer.parseInt(cars));
    }

    @DisplayName("Racing 객체 생성 시 try count 갯수확인")
    @ParameterizedTest(name = "{index} {displayName} param={0}")
    @CsvSource(value = {"5:1", "2:3", "10:13"}, delimiter = ':')
    void constructorWithTryCount(String cars, String trycnt) throws NoSuchFieldException, IllegalAccessException {
        Racing racing = new Racing(cars, trycnt);
        Field tryCount = Racing.class.getDeclaredField("tryCount");
        tryCount.setAccessible(true);
        IntStream inputTryCount = (IntStream) tryCount.get(racing);
        assertThat(inputTryCount.count()).isEqualTo(Integer.parseInt(trycnt));
    }

    @Test
    @DisplayName("racing 게임 결과 확인")
    void gameStart() {
        Racing racing = new Racing("4", "9");
        racing.start();
    }
}