package racingcar;

import java.util.List;

public class Print {
	public static void participantsOfRacing() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static void howManyMatches() {
		System.out.println("시도할 회수는 몇 회 인가요?");
	}

	public static void newLine() {
		System.out.println();
	}

	public static void printResult(String name, String status) {
		System.out.println(name + " : " + status);
	}

	public static void execute() {
		System.out.println("실행 결과");
	}

	public static void printWinner(List<Car> winners) {
		String temp = "";
		for (Car winner : winners) {
			temp += winner.getName() + ", ";
		}
		System.out.println(temp.substring(0, temp.length() - 2) + "가 최종 우승했습니다");
	}
}
