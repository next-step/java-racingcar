import java.util.Scanner;

public class InputView {
	static int inputChanceNumber() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	static int inputCarNumber() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
