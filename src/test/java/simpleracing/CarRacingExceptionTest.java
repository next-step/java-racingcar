package simpleracing;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import simpleracing.input.CarRacingInput;

@DisplayName("자동차 경주 예외 테스트")
public class CarRacingExceptionTest {

	private CarRacingInput carRacingInput;
	private ByteArrayInputStream testIn;

	@BeforeEach
	public void before() {
		this.carRacingInput = new CarRacingInput();
	}

	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	@DisplayName("생성할 자동차 수를 입력하지 않았을 때 발생하는 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"\n", "  \n"})
	public void carCountEmptyExceptionTest(String carCount) {
		provideInput(carCount);

		assertThatIllegalArgumentException().isThrownBy(() -> carRacingInput.input())
											.withMessage("질문에 대한 내용을 입력해주세요.");
	}

	@DisplayName("생성할 자동차 수가 0대 이하일 때 발생하는 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"0", "-1", "-200", "-37"})
	public void generatedCarCountExceptionTest(String carCount) {
		provideInput(carCount);

		assertThatIllegalArgumentException().isThrownBy(() -> carRacingInput.input())
											.withMessage("자동차 대수는 0대 이하일 수 없습니다.");
	}

	@DisplayName("생성할 자동차 수에 문자로 입력했을 때 발생하는 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"s", "a", "monitor", "tdd", "-"})
	public void carCountCharExceptionTest(String carCount) {
		provideInput(carCount);

		assertThatIllegalArgumentException().isThrownBy(() -> carRacingInput.input())
											.withMessage("숫자로 입력해주세요.");
	}

	@DisplayName("생성할 게임 회수를 입력하지 않았을 때 발생하는 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"10\n\n", "3\n   "})
	public void gameCountEmptyExceptionTest(String input) {
		provideInput(input);

		assertThatIllegalArgumentException().isThrownBy(() -> carRacingInput.input())
											.withMessage("질문에 대한 내용을 입력해주세요.");
	}

	@DisplayName("생성할 게임 회수가 0회 이하일 때 발생하는 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"10\n-20", "1\n-1", "3\n-200", "20\n-37", "20\n0"})
	public void generatedGameCountExceptionTest(String input) {
		provideInput(input);

		assertThatIllegalArgumentException().isThrownBy(() -> carRacingInput.input())
											.withMessage("시도할 회수는 0회 이하일 수 없습니다.");
	}

	@DisplayName("생성할 게임 회수에 문자로 입력했을 때 발생하는 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"10\ns", "10\na", "10\nmonitor", "10\ntdd", "10\n-"})
	public void gameCountCharExceptionTest(String carCount) {
		provideInput(carCount);

		assertThatIllegalArgumentException().isThrownBy(() -> carRacingInput.input())
											.withMessage("숫자로 입력해주세요.");
	}
}
