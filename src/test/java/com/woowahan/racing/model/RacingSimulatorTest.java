package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RacingSimulatorTest {

	@DisplayName("createSimulator메서드는 InputResult객체를 전달하면 RacingSimulator객체를 반환한다.")
	@ParameterizedTest
	@MethodSource("argCreateSimulator")
	void createSimulator(InputResult param) {

		RacingSimulator result = RacingSimulator.createSimulator(param);

		assertThat(result).isInstanceOf(RacingSimulator.class);
	}

	public static Stream<Arguments> argCreateSimulator() {
		return Stream.of(
			Arguments.of(InputResult.of(10, 1)),
			Arguments.of(InputResult.of(1, 10)),
			Arguments.of(InputResult.of(7, 3))
		);
	}

	@DisplayName("run 메서드의 결과는 InputResult의 carCount만큼의 Car수와  tryCount만큼 GameResult객체의 수를 가진다.")
	@ParameterizedTest
	@CsvSource(value = {"3:5", "1:9", "2:10"}, delimiter = ':')
	void run(int carCount, int tryCount) {

		InputResult inputResult = InputResult.of(carCount, tryCount);

		RacingSimulator simulator = RacingSimulator.createSimulator(inputResult);
		List<GameResult> gameResults = simulator.run();
		int trySize = gameResults.size();
		assertAll(
			() -> assertThat(trySize).isEqualTo(tryCount),
			() -> {
				for (GameResult gameResult : gameResults) {
					int carSize = gameResult.getCars().size();
					assertThat(carSize).isEqualTo(carCount);
				}
			}
		);
	}
}