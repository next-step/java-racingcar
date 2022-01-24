package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void 참여자는_두_명_이상이다_실패() {
        String[] carNames = "car1".split(",");

        assertThrows(IllegalArgumentException.class,
                () -> Validator.validatePossibleToStart(carNames));
    }

    @Test
    void 참여자는_두_명_이상이다_성공() {
        String[] carNames = "car1,car2".split(",");

        assertDoesNotThrow(() -> Validator.validatePossibleToStart(carNames));
    }

    @Test
    void carNames_정상_입력() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("car1,car2".getBytes());
        System.setIn(inputStream);

        String[] carNames = Input.getCarNames();

        assertThat(carNames[0]).isEqualTo("car1");
        assertThat(carNames[1]).isEqualTo("car2");
    }

    @Test
    void 시도횟수_정상_입력() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("5".getBytes());
        System.setIn(inputStream);

        int trial = Input.getTrial();

        assertThat(trial).isEqualTo(5);
    }

    @Test
    void 시도횟수_입력값에_불필요한_공백이_들어왔을_때_제거() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("1 0".getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> Input.getTrial());
    }

    @Test
    void 시도횟수_입력값에_불필요한_공백이_들어왔을_때_제거_값_잘들어오는지() throws IOException {

        InputStream inputStream = new ByteArrayInputStream("1 0".getBytes());
        System.setIn(inputStream);

        int input = Input.getTrial();
        assertThat(input).isEqualTo(10);
    }

    @Test
    void carName_입력값에_불필요한_공백이_들어왔을_때_제거() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("car1, car2, c ar3".getBytes());
        System.setIn(inputStream);

        String[] carNames = Input.getCarNames();

        assertThat(carNames[0]).isEqualTo("car1");
        assertThat(carNames[1]).isEqualTo("car2");
        assertThat(carNames[2]).isEqualTo("car3");
    }
}