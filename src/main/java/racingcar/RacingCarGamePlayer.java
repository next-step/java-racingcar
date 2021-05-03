package racingcar;

import java.util.Map;
import java.util.Scanner;

public class RacingCarGamePlayer {
	public static void play() {
		Scanner scan = new Scanner(System.in);
		RacingCarGame game = null;
		while (game == null) {
			String carNames = askCarNames(scan);
			int roundCount = askRoundCount(scan);
			game = startRaceGame(carNames, roundCount);
		}
		scan.close();
		printAllRoundScore(game);
		printWinners(game);
	}

	private static RacingCarGame startRaceGame(String carNames, int roundCount) {
		try {
			return new RacingCarGame(carNames, roundCount);
		} catch (IllegalArgumentException e) {
			System.out.println("정보를 다시 입력해주세요.");
		}
		return null;
	}

	private static String askCarNames(Scanner scan) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
		return scan.next();
	}

	private static int askRoundCount(Scanner scan) {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return scan.nextInt();
	}

	private static void printAllRoundScore(RacingCarGame game) {
		StringBuffer sb = new StringBuffer("");
		sb.append("\n실행 결과");
		for (Map<String, Integer> scoresOfRound : game.getAllRoundScore()) {
			sb.append(toScoreInformation(scoresOfRound) + "\n");
		}
		System.out.println(sb.toString());
	}

	private static String toScoreInformation(Map<String, Integer> scoresOfRound) {
		StringBuffer sb = new StringBuffer("");
		String carNames[] = scoresOfRound.keySet().toArray(new String[0]);
		for (int i = 0; i < carNames.length; i++) {
			sb.append("\n" + carNames[i] + " : " + toDash(scoresOfRound.get(carNames[i])));
		}
		return sb.toString();
	}

	private static String toDash(int number) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < number; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	private static void printWinners(RacingCarGame game) {
		String winners = String.join(", ", game.getWinners());
		System.out.print(winners + "가 최종 우승했습니다.");
	}
}
