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
    @BeforeEach
    void setUp() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("3\n5".getBytes());
        System.setIn(byteArrayInputStream);
    }

    @Test
    void random_int_test() {
        RacingGame racingGame = new RacingGame(System.in);
        assertThat(racingGame.getRandomIntValue()).isBetween(0, 10);
    }
}
