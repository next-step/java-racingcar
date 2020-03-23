package racing;

import racing.UI.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {

	private final InputStream systemIn = System.in;

	void provideInput(String cars, String times) {
		ByteArrayInputStream in = new ByteArrayInputStream( (cars + "\n" + times).getBytes() );
		System.setIn(in);
	}

	@AfterEach
	void restoreInput() {
		System.setIn(systemIn);
	}

	@ParameterizedTest
	@CsvSource(value = {"-1,-1", "0,0", "2,0", "0,3"})
	void validationInputDataWithInvalidCase(String cars, String times) {
		provideInput(cars, times);
		InputView inputView = new InputView();
		assertThatIllegalArgumentException().isThrownBy(inputView::input);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1", "2,1"})
	void validationInputDataWithValidCase(String cars, String times) {
		provideInput(cars, times);
		InputView inputView = new InputView();
		inputView.input();
	}
}
