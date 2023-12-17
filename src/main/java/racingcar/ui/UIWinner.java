package racingcar.ui;

import java.util.List;

public class UIWinner {
	public static void printResult(List<String> winners) {
		System.out.println(String.join(",", winners) + " 가 최종 우승했습니다.");
	}
}
