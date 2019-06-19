package racing.view;

import racing.vo.StageOption;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleDialogView {

	public static StageOption use() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("레이싱에 참여 할 수 있는 자동차는 몇 대 인가요?");
		int entrySize = scanner.nextInt();

		System.out.println("시도할 회수는 몇 회 인가요?");
		int round = scanner.nextInt();


		return new StageOption(entrySize, round);
	}
}
