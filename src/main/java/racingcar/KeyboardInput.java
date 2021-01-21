package racingcar;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class KeyboardInput implements Input {
    private final Scanner scanner;

    public KeyboardInput(InputStream source) {
        this.scanner = new Scanner(source);
    }

    @Override
    public List<String> getCarNames() {
        // TODO: 사용자에게 출력할 메시지는 인자로 받도록
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        return InputParser.parseCarNames(carNames);
    }

    @Override
    public int getRounds() {
        // TODO: 사용자에게 출력할 메시지는 인자로 받도록
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
