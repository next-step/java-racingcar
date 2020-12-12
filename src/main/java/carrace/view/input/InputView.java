package carrace.view.input;


import carrace.domain.CarName;
import carrace.view.input.scanner.CountInputScanner;
import carrace.view.input.scanner.InputScanner;
import carrace.view.input.scanner.NameInputScanner;

import java.util.List;

public class InputView<T> {
    private static final InputScanner<List<CarName>> nameInputScanner = new NameInputScanner();
    private static final InputScanner<Integer> countInputScanner = new CountInputScanner();

    public static List<CarName> scanCarName() {
        return nameInputScanner.repeatScan("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static int scanTryCount() {
        return countInputScanner.repeatScan("시도할 회수는 몇 회 인가요?");
    }
}
