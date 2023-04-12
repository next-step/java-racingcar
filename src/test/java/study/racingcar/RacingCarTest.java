package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("숫자를 입력시 자동차 대수를 반환 해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2"})
    public void inputView_setCars_숫자(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.setCars()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자를 입력시 게임 횟수를 반환 해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"5"})
    public void inputView_setGames_숫자(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.setGames()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("차량수 숫자가 양수인 경우 입력할 경우 True 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    public void settingGame_createCars_양수(int cars) {

        assertThat(SettingGame.createCars(cars)).hasSize(cars);
    }

    @DisplayName("차량수 숫자가 음수 또는 0인 경우 입력할 경우 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void settingGame_createCars_음수(int cars) {

        assertThatThrownBy(() -> SettingGame.createCars(cars))
                .isInstanceOf(InputMismatchException.class);
    }

    @DisplayName("차량수에 따라 Car List 를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    public void settingGame_createCars(int cars) {

        assertThat(SettingGame.createCars(cars)).hasSize(cars);
    }

    @DisplayName("랜덤 값을 생성할 때 범위내에 존재하는지 테스트")
    @Test
    public void generateNumber_random_범위내에_있는지_테스트() {

        assertThat(GenerateNumber.random()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
