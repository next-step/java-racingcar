package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.controller.GameController;
import racingcar.dto.CarDto;
import racingcar.dto.Result;
import racingcar.strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class GameControllerTest {

	private static final List<String> NAMES = List.of("0chil", "g");
	private static final int TRIAL_COUNT = 2;
	private static final MoveStrategy MOVE_STRATEGY_ALWAYS_MOVE = () -> true;

	private InputView inputView;
	private OutputView outputView;

	private List<String> outputNames;
	private List<Result> outputResults;

	@BeforeEach
	void setUp() {
		outputNames = new ArrayList<>();
		outputResults = new ArrayList<>();

		inputView = new InputView() {
			@Override
			public List<String> readTrimmedNames() {
				return NAMES;
			}

			@Override
			public int readTrialCount() {
				return TRIAL_COUNT;
			}
		};

		outputView = new OutputView() {
			@Override
			public void printWinners(List<String> names) {
				outputNames = names;
			}

			@Override
			public void printResults(List<Result> results) {
				outputResults = results;
			}
		};
	}

	@Test
	@DisplayName("게임 플레이를 테스트한다")
	void play() {
		GameController gameController = new GameController(inputView, outputView, MOVE_STRATEGY_ALWAYS_MOVE);
		gameController.play();

		assertThat(outputNames).containsAll(NAMES);
		assertThat(outputResults).last().satisfies(result -> assertThatHasUniformPositionOf(result, TRIAL_COUNT));
	}

	private void assertThatHasUniformPositionOf(Result result, int position) {
		assertThat(result.getCarDtos())
			.allMatch(carDto -> hasCarDtoPositionOf(carDto, position));
	}

	private boolean hasCarDtoPositionOf(CarDto carDto, int position) {
		return carDto.getPosition().equals(position);
	}
}