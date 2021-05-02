package racingcar;

import java.util.Map;
import java.util.Scanner;

public class RacingCarGamePlayer {
	public static void play() {
		Scanner scan = new Scanner(System.in);
		String carNames = askCarNames(scan);
		int roundCount = askRoundCount(scan);
		scan.close();

		RacingCarGame game = new RacingCarGame(carNames, roundCount);
		printAllRoundScore(game);
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
}
