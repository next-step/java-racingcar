package carrace.ui.input;


import carrace.ui.input.scanner.CountInputScanner;
import carrace.ui.input.scanner.InputScanner;
import carrace.ui.input.scanner.NameInputScanner;

public class InputView<T> {
    private static final InputScanner<String[]> nameInputScanner = new NameInputScanner();
    private static final InputScanner<Integer> countInputScanner = new CountInputScanner();

    public static String[] scanCarName() {
        return nameInputScanner.repeatScan("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static int scanTryCount() {
        return countInputScanner.repeatScan("시도할 회수는 몇 회 인가요?");
    }
}
