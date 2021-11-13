package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TerminalInputView {

    private static final String NAME_SEPARATOR = ",";

    private TerminalInputView() {}

    public static List<String> inputNamesOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return Arrays.asList(
                line.split(NAME_SEPARATOR));
    }

    public static int inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return inputNextIntToSystemInScanner();
    }

    public static int inputNumberOfMove() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return inputNextIntToSystemInScanner();
    }

    private static int inputNextIntToSystemInScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
