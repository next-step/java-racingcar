package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {

//    @DisplayName("차량수 숫자가 양수인 경우 입력할 경우 True 를 반환한다.")
//    @ParameterizedTest
//    @ValueSource(ints = {4, 5, 6})
//    public void settingGame_createCars_양수(int cars) {
//
//        assertThat(SettingGame.createCars(cars)).hasSize(cars);
//    }
//
//    @DisplayName("차량수 숫자가 음수 또는 0인 경우 입력할 경우 예외를 반환한다.")
//    @ParameterizedTest
//    @ValueSource(ints = {-1, 0})
//    public void settingGame_createCars_음수(int cars) {
//
//        assertThatThrownBy(() -> SettingGame.createCars(cars))
//                .isInstanceOf(InputMismatchException.class);
//    }
//
//    @DisplayName("차량수에 따라 Car List 를 만든다.")
//    @ParameterizedTest
//    @ValueSource(ints = {4, 5, 6})
//    public void settingGame_createCars(int cars) {
//
//        assertThat(SettingGame.createCars(cars)).hasSize(cars);
//    }

    @DisplayName("랜덤 값을 생성할 때 범위내에 존재하는지 테스트")
    @Test
    public void generateNumber_random_범위내에_있는지_테스트() {

        assertThat(GenerateNumber.random()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @DisplayName("자동차 경주 중 최고 거리의 위치를 반환한다.")
    @Test
    public void gameWinner_getMaxPosition() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car(3, "pobbi");
        Car car2 = new Car(5, "crong");
        Car car3 = new Car(4, "honux");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameWinner gameWinner = new GameWinner(carList);

        assertThat(gameWinner.getMaxPosition(carList)).isEqualTo(5);

    }

    @DisplayName("동일한 최고 거리가 1명이면 우승자는 1명이다.")
    @Test
    public void gameWinner_findGameWinner_우승자1명() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car(3, "pobbi");
        Car car2 = new Car(5, "crong");
        Car car3 = new Car(8, "honux");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameWinner gameWinner = new GameWinner(carList);

        assertThat(gameWinner.findGameWinner()).hasSize(1);

    }

    @DisplayName("동일한 최고 거리가 2명이면 우승자는 2명이다.")
    @Test
    public void gameWinner_findGameWinner_우승자2명() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car(3, "pobbi");
        Car car2 = new Car(5, "crong");
        Car car3 = new Car(5, "honux");

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameWinner gameWinner = new GameWinner(carList);

        assertThat(gameWinner.findGameWinner()).hasSize(2);

    }
}
