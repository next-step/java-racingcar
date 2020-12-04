package com.woowahan.racing.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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

	@DisplayName("run 메서드는 List<GameResult> 형태의 결과를 반환한다.")
	@ParameterizedTest
	@MethodSource("argCreateSimulator")
	void run(InputResult param) {

		RacingSimulator simulator = RacingSimulator.createSimulator(param);
		List<GameResult> result = simulator.run();

		assertAll(
			() -> assertThat(result).isInstanceOf(List.class),
			() -> assertThat(result).hasOnlyElementsOfType(GameResult.class)
		);
	}
}