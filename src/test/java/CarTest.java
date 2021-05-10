import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.Car;
import racing.RacingGame;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racing.RacingGame.SEPARATOR;

public class CarTest {
    @Test
    @DisplayName("난수가 4이상일때 거리 증가")
    public void moveTest() {
        //given
        Car car = new Car("aaa");
        int randomNumber = 4;
        int moveCount = car.getMoveCount();

        //when
        car.move(randomNumber);

        //then
        assertThat(car.getMoveCount()).isEqualTo(moveCount + 1);
    }

    @Test
    @DisplayName("난수가 4미만일때 거리변화 없음")
    public void notMoveTest() {
        //given
        Car car = new Car("aaa");
        int randomNumber = 2;
        int moveCount = car.getMoveCount();

        //when
        car.move(randomNumber);

        //then
        assertThat(car.getMoveCount()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1", "5:1", "6:1"}, delimiter = ':')
    @DisplayName("난수가 4미만일때 거리변화 없음 5이상일경우 변화 있음")
    public void 난수의조건을모두체크(int randomNumber, int changedMoveCount) {
        //given
        Car car = new Car("aaa");

        //when
        car.move(randomNumber);

        //then
        assertThat(changedMoveCount).isEqualTo(car.getMoveCount());
    }

    @Test
    @DisplayName("자동차 이름이 전부 5자 이내인 자동차 생성")
    public void makeCarTest() {
        assertAll(
                () -> assertThat(new Car("aaa").getName()).isEqualTo("aaa"),
                () -> assertThat(new Car("bbb").getName()).isEqualTo("bbb"),
                () -> assertThat(new Car("ccc").getName()).isEqualTo("ccc")
        );
    }

    @Test
    @DisplayName("자동차 이름중 일부가 5자 초과")
    public void invalidMakeCarTest() {
        //given
        String carString = "aaa,bbb,cccccc";
        String[] carNameArray = carString.split(SEPARATOR);

        //when

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(carNameArray[2]);
                });
    }
}
