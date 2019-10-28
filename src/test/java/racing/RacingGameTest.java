package racing;

import org.junit.jupiter.api.Test;

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

    private final InputStream systemIn = System.in;
    private CarRacingGame racingGame;
    private static final String CAR_AMOUNT = "3";

    void setInputAmount(String carAmount, String roundAmount) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(String.format("%s\n%s", carAmount, roundAmount).getBytes());
        System.setIn(byteArrayInputStream);
        racingGame = new CarRacingGame(System.in);
    }

    @Test
    void random_int_test() {
        setInputAmount("3", "5");
        assertThat(racingGame.getRandomIntValue()).isBetween(0, 10);
    }

    @Test
    void putParticipantCarMap_게임에_참가하는_자동차_테스트() {
        setInputAmount("3", "5");
        assertThat(racingGame.getParticipantCarCount()).isEqualTo(3);
        assertThat(racingGame.getParticipantCarCount()).isEqualTo(5);
    }

    @Test
    void car_move_test() {
        setInputAmount("3", "5");
        assertThat(CarNextStep.isMoved(racingGame.getRandomIntValue())).isEqualTo(CarNextStep.GO);
        assertThat(CarNextStep.isMoved(racingGame.getRandomIntValue())).isEqualTo(CarNextStep.STOP);
    }

    @Test
    void mit_input_value_test() {
        assertThatExceptionOfType(InputMismatchException.class).isThrownBy(() -> {
            setInputAmount("0", "5");
            racingGame.start();
        }).withMessageMatching("0보다 큰 숫자만 입력이 가능합니다.");
    }

    @Test
    void invalid_input_value_test() {
        assertThatExceptionOfType(InputMismatchException.class).isThrownBy(() -> {
            setInputAmount("asdfs", "5");
            racingGame.start();
        }).withMessageMatching("숫자만 입력 가능합니다.");
    }
}
