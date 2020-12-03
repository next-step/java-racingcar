package com.woowahan.racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingSimulator {

	private final InputResult inputResult;
	private final List<GameResult> gameResultList;

	private RacingSimulator(InputResult inputResult) {
		this.inputResult = inputResult;
		this.gameResultList = new ArrayList<>();
	}

	public static RacingSimulator getInstance(InputResult inputResult) {
		return new RacingSimulator(inputResult);
	}

	public List<GameResult> getGameResultList() {
		return gameResultList;
	}

	public void run(){
		throw new RuntimeException("게임을 실행하고 결과를 객체에 저장한다.");
	}
}
