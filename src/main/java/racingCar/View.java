package racingCar;

import java.util.List;
import java.util.Scanner;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class View {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	public static int inputMatchCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return scanner.nextInt();
	}

	public static void printResult(Cars resultCars) {
		RaceHistory history = resultCars.getHistory();
		List<LapHistory> lapHistories = history.get();
		System.out.println("실행 결과");
		for (LapHistory lapHistory : lapHistories) {
			printLapResult(lapHistory);
			System.out.println("");
		}
	}

	private static void printLapResult(LapHistory lapHistory) {
		for (CarHistory carHistory : lapHistory.get()) {
			printPosition(carHistory);
			System.out.println("");
		}
	}

	private static void printPosition(CarHistory carHistory) {
		System.out.print(carHistory.getName() + " : ");
		for (int i = 0; i < carHistory.getPosition(); i++) {
			System.out.print("-");
		}
	}

	public static String requireCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return scanner.nextLine();
	}
}
