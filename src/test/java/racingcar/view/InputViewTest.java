package racingcar.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.view.InputView;
import testutils.IOTest;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest extends IOTest {

  @Test
  void 메세지_출력() {
    final String INPUT_GUIDE_MESSAGE = "TEST";
    final String DUMMY_INPUT = "TEST";
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    setOutputStream(outputStream);
    setInputStream(DUMMY_INPUT.getBytes());

    InputView.getInput(INPUT_GUIDE_MESSAGE);
    assertThat(outputStream.toString()).isEqualTo(INPUT_GUIDE_MESSAGE.concat("\r\n"));
  }

  @ParameterizedTest
  @CsvSource(value = { "test:test", "test1,test2,test3:test1,test2,test3"}, delimiter = ':')
  void 값_입력(String input, String expected) {
    setInputStream(input.getBytes());
    assertThat(InputView.getInput("TEST")).isEqualTo(expected);
  }
}
