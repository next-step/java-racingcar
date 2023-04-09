package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("숫자를 입력시 자동차 대수를 반환 해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void setCars_숫자(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.setCars()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자를 입력시 게임 횟수를 반환 해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6"})
    public void setGames_숫자(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.setGames()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("차량수, 게임수 숫자가 음수 또는 0인 경우 입력할 경우 예외를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"-1:2", "0:3", "2:0", "4:-1"}, delimiter = ':')
    public void setGame_음수(int cars, int gaems) {

        assertThatThrownBy(() -> SettingGame.isCheckSetGame(cars, gaems))
                .isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("랜덤 값을 생성할 때 범위내에 존재하는지 테스트")
    void generateRandomNum_범위내에_있는지_테스트() {
        int randomNum = RacingGame.generateRandomNumber();
        assertThat(randomNum).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
