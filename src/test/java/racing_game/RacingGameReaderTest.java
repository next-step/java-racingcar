package racing_game;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameReaderTest {

    @Test
    public void 게임_횟수_읽기() {
        final int tryCount = 5;
        final InputStream inputStream = new ByteArrayInputStream(String.valueOf(tryCount).getBytes());

        try(RacingGameReader racingGameReader = new RacingGameReader(inputStream)) {

            int readTryCount = racingGameReader.readTryCount();

            assertThat(readTryCount).isEqualTo(tryCount);
        }
    }

    @Test
    public void 자동차_이름_읽기() {
        final String stringCarNames = "pobi,crong,honux";
        final InputStream inputStream = new ByteArrayInputStream(stringCarNames.getBytes());

        try(RacingGameReader racingGameReader = new RacingGameReader(inputStream)) {

            String[] carNames = racingGameReader.readCarName();

            assertThat(carNames.length).isEqualTo(3);
            assertThat(String.join(",", carNames)).isEqualTo(stringCarNames);
        }
    }
}