package study.step5.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import study.step5.domain.movestrategy.RandomMoveStrategy;
import study.step5.domain.racinggame.RacingGame;
import study.step5.domain.racinggame.RacingGameInfo;
import study.step5.domain.util.StringUtil;

public class RacingGameView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String SEPARATOR = ",";
	private static final RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame(
			new RacingGameInfo(
				StringUtil.toCars(getNames()),
				getRound(),
				randomMoveStrategy
			)
		);

		System.out.println("실행결과");
		racingGame.start();
		racingGame.end();
	}

	public static List<String> getNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String input = SCANNER.next();
		return Arrays.asList(input.split(SEPARATOR));
	}

	public static int getRound() {
		System.out.println("시도할 회수는 몇회인가요?");
		return SCANNER.nextInt();
	}
}
