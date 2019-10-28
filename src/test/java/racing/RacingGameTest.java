package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 00:37
 */
public class RacingGameTest {

    private final InputStream systemIn = System.in;
    private RacingGame racingGame;
    private static final String CAR_AMOUNT = "3";
    private static final String ROUND_AMOUNT = "5";

    @BeforeEach
    void setUp() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(String.format("%s\n%s", CAR_AMOUNT, ROUND_AMOUNT).getBytes());
        System.setIn(byteArrayInputStream);
        racingGame = new RacingGame(System.in);;
    }

    @Test
    void random_int_test() {
        assertThat(racingGame.getRandomIntValue()).isBetween(0, 10);
    }

    @Test
    void putParticipantCarMap_게임에_참가하는_자동차_테스트() {
        assertThat(racingGame.getParticipantCarCount()).isEqualTo(3);
        assertThat(racingGame.getParticipantCarCount()).isEqualTo(5);
    }

    @Test
    void car_move_test() {
        assertThat(CarNextStep.isMoved(racingGame.getRandomIntValue())).isEqualTo(CarNextStep.GO);
        assertThat(CarNextStep.isMoved(racingGame.getRandomIntValue())).isEqualTo(CarNextStep.STOP);
    }
}
