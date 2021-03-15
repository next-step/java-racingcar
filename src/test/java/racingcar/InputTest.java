package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import racingcar.view.InputView;
import racingcar.view.InputViewCarName;

public class InputTest {

	@Test
	void inputViewCarNameTest() {
		byte[] carName = "abc,def,ccc".getBytes();
		InputStream inputStream = new ByteArrayInputStream(carName);

		InputView<String[]> inputViewCarName = new InputViewCarName("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
			new InputStreamReader(inputStream));

		assertThat(inputViewCarName.getInput()).containsExactly("abc", "def", "ccc");
	}
}
