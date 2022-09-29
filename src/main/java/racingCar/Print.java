package racingCar;

import java.util.Collections;
import java.util.List;

public class Print {
	public static void participantsOfRacing() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static void howManyCars() {
		System.out.println("자동차 대수는 몇 대 인가요?");
	}

	public static void howManyMatches() {
		System.out.println("시도할 회수는 몇 회 인가요?");
	}

	public static void resultOfRound(List<Integer> status) {
		System.out.println(status);
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
	//
	// public static void winner(Cars cars, List<Integer> winners) {
	// 	String temp = "";
	// 	for (int i = 0; i < winners.size(); i++) {
	// 		temp += cars.getCars().get(winners.get(i)).getName() + ", ";
	// 	}
	//
	// 	String win = temp.substring(0, temp.length() - 2);
	//
	// 	System.out.println(win + "가 최종 우승했습니다");
	// }
}
