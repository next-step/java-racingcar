import java.util.Scanner;

import racing.Command;
import racing.Racecourse;
import racing.Winners;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		String nameLine = sc.nextLine();
		System.out.println("시도할 회수는 몇회인가요?");
		int count = sc.nextInt();
		start(new Command(count, nameLine));
	}

	private static void start(Command command) {
		Racecourse racecourse = new Racecourse();
		racecourse.init(command);
		racecourse.run();
		Winners winners = racecourse.getWinners();
		System.out.printf("%s가 최종 우승하였습니다.%n", winners.getWinnerNames());
	}
}