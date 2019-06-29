package racing.view;

import racing.vo.StageOption;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleDialogView {

	private static final String SEPARATOR = ",";

	public static StageOption use() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String playerNames = scanner.nextLine();

		System.out.println("시도할 회수는 몇 회 인가요?");
		int round = scanner.nextInt();

		System.out.println();	// 빈줄 출력

		return new StageOption(playerNames, SEPARATOR, round);
	}
}
