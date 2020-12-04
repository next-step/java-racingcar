package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.woowahan.racing.constant.Message;

class RacingSimulatorTest {

	private static final int MIN_WINNER_COUNT = 1;

	@DisplayName("createSimulator메서드는 InputResult객체를 전달하면 RacingSimulator객체를 반환한다.")
	@ParameterizedTest
	@MethodSource("argCreateSimulator")
	void createSimulator(InputResult param) {

		RacingSimulator result = RacingSimulator.createSimulator(param);

		assertThat(result).isInstanceOf(RacingSimulator.class);
	}

	@DisplayName("run 메서드의 결과는 InputResult의 carCount만큼의 Car수와  tryCount만큼 GameResult객체의 수를 가진다.")
	@ParameterizedTest
	@MethodSource("argCreateSimulator")
	void run(InputResult inputResult) {

		int carCount = inputResult.getCarCount();
		int tryCount = inputResult.getTryCount();

		RacingSimulator simulator = RacingSimulator.createSimulator(inputResult);
		List<GameResult> gameResults = simulator.run();
		assertAll(
			() -> assertThat(gameResults).hasSize(tryCount),
			() -> {
				for (GameResult gameResult : gameResults) {
					assertThat(gameResult.getCars()).hasSize(carCount);
				}
			}
		);
	}

	@DisplayName("getWinners메서드는 우승자를 최소 1명 이상 반환한다.")
	@ParameterizedTest
	@MethodSource("argCreateSimulator")
	void getWinners(InputResult inputResult) {

		RacingSimulator simulator = RacingSimulator.createSimulator(inputResult);
		simulator.run();
		List<String> result = simulator.getWinners();
		assertThat(result.size()).isGreaterThanOrEqualTo(MIN_WINNER_COUNT);
	}

	@DisplayName("getWinners메서드는 RacingSimulator run메서드를 실행하지 않고 실행하는 경우 IllegalStateException이 발생한다.")
	@ParameterizedTest
	@MethodSource("argCreateSimulator")
	void getWinnersThrow(InputResult inputResult) {

		RacingSimulator simulator = RacingSimulator.createSimulator(inputResult);
		assertThatExceptionOfType(IllegalStateException.class)
			.isThrownBy(simulator::getWinners).withMessage(Message.MSG_REQUEST_SIMULATOR_RUN);
	}

	public static Stream<Arguments> argCreateSimulator() {
		return Stream.of(
			Arguments.of(InputResult.of(Arrays.asList("abc"), 1)),
			Arguments.of(InputResult.of(Arrays.asList("abc", "가나다라"), 10)),
			Arguments.of(InputResult.of(Arrays.asList("abc", "가나다라", "bc"), 3))
		);
	}
}