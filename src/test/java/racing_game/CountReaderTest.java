package racing_game;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CountReaderTest {

    @Test
    public void 자동차_수_읽기() {
        final int carCount = 4;
        final InputStream inputStream = new ByteArrayInputStream(String.valueOf(carCount).getBytes());

        try(CountReader countReader = new CountReader(inputStream)){

            int readCarCount = countReader.readCarCount();

            assertThat(readCarCount).isEqualTo(carCount);
        }
    }

    @Test
    public void 게임_횟수_읽기() {
        final int tryCount = 5;
        final InputStream inputStream = new ByteArrayInputStream(String.valueOf(tryCount).getBytes());

        try(CountReader countReader = new CountReader(inputStream)) {

            int readTryCount = countReader.readTryCount();

            assertThat(readTryCount).isEqualTo(tryCount);
        }
    }

}