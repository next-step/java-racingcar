package racing;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.UI.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.UI.ResultView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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
	void checkValidationInputDataWithInvalidCase(String cars, String times) {
		provideInput(cars, times);
		InputView inputView = new InputView();
		assertThatIllegalArgumentException().isThrownBy(inputView::input);
	}

	private static Stream<Arguments> getValidCase() {
		List<Arguments> argumentsList = new ArrayList<>();
		argumentsList.add(Arguments.of("1","1"));
		argumentsList.add(Arguments.of("2","1"));
		argumentsList.add(Arguments.of("3","5"));
		return argumentsList.stream();
	}

	@ParameterizedTest
	@MethodSource("getValidCase")
	void checkValidationInputDataWithValidCase(String cars, String times) {
		provideInput(cars, times);
		InputView inputView = new InputView();
		inputView.input();
	}

	@ParameterizedTest
	@MethodSource("getValidCase")
	void checkInitializationCarPositions(int cars, int times) {
		RacingGame game = new RacingGame(cars, times);
		ArrayList<Integer> carPositions = game.getCarPositions();
		assertThat(carPositions.stream().allMatch(carPos -> carPos == RacingGame.INIT_CAR_POSITION)).isTrue();
	}

	@ParameterizedTest
	@MethodSource("getValidCase")
	void checkMove(int cars, int times) {
		RacingGame game = new RacingGame(cars, times);
		ArrayList<Integer> carPositions;

		ResultView resultView = new ResultView();
		resultView.printTitle();

		for (int i = 0; i < game.getTime(); ++i) {
			carPositions = game.move();
			resultView.print(carPositions);
		}
	}
}
