package com.woowahan.racing.view;

import java.util.List;

import com.woowahan.racing.model.GameResult;

public class ResultView {

	public static void printResult(List<GameResult> gameResultList) {
		printResultHeader();
		for (GameResult gameResult : gameResultList) {
			printEachResult(gameResult);
		}
	}

	public static void printResultHeader() {
		System.out.println("실행 결과:");
	}

	public static void printEachResult(GameResult gameResult) {
		gameResult.getCarList()
			.forEach(car -> System.out.println(car.getDistance()));
		System.out.println();
	}

}
