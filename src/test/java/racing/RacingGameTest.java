package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.*;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 00:37
 */
public class RacingGameTest {

    private static final String CAR_AMOUNT = "3";
    private final InputStream systemIn = System.in;
    private RacingGameInputView racingGameInputView;

    void setInputAmount(String carAmount, String roundAmount) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(String.format("%s%s%s", carAmount, System.lineSeparator(),roundAmount).getBytes());
        System.setIn(byteArrayInputStream);
        racingGameInputView = new RacingGameInputView(System.in);
    }

    @ParameterizedTest
    @ValueSource(ints = {10})
    void random_int_test(int bound) {
        setInputAmount("3", "5");
        assertThat(RandomValue.getInt(bound)).isBetween(0, 10);
    }

    @Test
    void putParticipantCarMap_게임에_참가하는_자동차_테스트() {
        setInputAmount("3", "5");
        assertThat(racingGameInputView.inputNumberCars()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {10})
    void car_move_test(int bound) {
        assertThat(CarNextStep.getGoOrStop(RandomValue.getInt(bound))).isEqualTo(CarNextStep.GO);
        assertThat(CarNextStep.getGoOrStop(RandomValue.getInt(bound))).isEqualTo(CarNextStep.STOP);
    }

    @Test
    void mit_input_value_test() {
        assertThatExceptionOfType(InputMismatchException.class).isThrownBy(() -> {
            setInputAmount("0", "5");
            racingGameInputView.inputNumberCars();
        }).withMessageMatching("0보다 큰 숫자만 입력이 가능합니다.");
    }

    @Test
    void invalid_input_value_test() {
        assertThatExceptionOfType(InputMismatchException.class).isThrownBy(() -> {
            setInputAmount("asdfs", "5");
            racingGameInputView.inputNumberCars();
        }).withMessageMatching("숫자만 입력 가능합니다.");
    }
}
