package com.woowahan.racing.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.model.Cars;
import com.woowahan.racing.model.GameResult;
import com.woowahan.racing.model.InputResult;
import com.woowahan.racing.model.RacingSimulator;

class GameReportTest {

	List<GameResult> gameResults;
	List<String> winners;

	private static final String CAR1_NAME = "자동차1";
	private static final String CAR2_NAME = "자동차2";
	private static final String CAR3_NAME = "자동차3";
	private static final int tryCount = 5;

	@BeforeEach
	void setup() {
		InputResult inputResult = InputResult.of(Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME), tryCount);
		RacingSimulator racingSimulator = RacingSimulator.createSimulator(inputResult);
		this.gameResults = racingSimulator.run();
		Cars partCars = racingSimulator.getPartCars();
		this.winners = partCars.getWinners();
	}

	@DisplayName("report메서드는 '실행 결과:'로 시작해서, '가 최종 우승했습니다'. 라는 글자가 포함된다.")
	@Test
	void report() {
		String report = GameReport.report(gameResults, winners);
		assertThat(report).startsWith(Message.MSG_REPORT_HEADER)
			.endsWith(Message.MSG_WINNER.substring(Message.MSG_WINNER.length() - 10));
	}

	@DisplayName("report메서드는 참여한 자동차 이름이 최소 trtCount만큼 나온다.")
	@Test
	void reportCar() {
		String report = GameReport.report(gameResults, winners);
		int car1Count = countMatch(report, CAR1_NAME);
		int car2Count = countMatch(report, CAR1_NAME);
		int car3Count = countMatch(report, CAR1_NAME);

		assertAll(
			() -> assertThat(car1Count).isGreaterThanOrEqualTo(tryCount),
			() -> assertThat(car2Count).isGreaterThanOrEqualTo(tryCount),
			() -> assertThat(car3Count).isGreaterThanOrEqualTo(tryCount)
		);
	}

	private int countMatch(String str, String find) {
		return (str.split(find, -1).length) - 1;
	}

}