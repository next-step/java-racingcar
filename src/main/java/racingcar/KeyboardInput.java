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
        // TODO: 사용자에게 출력할 메시지를 담고 있는 별도 클래스 생성
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        // TODO: 중복된 이름이 존재하는 경우에 대한 예외 처리
        String carNames = scanner.nextLine();
        return InputParser.parseCarNames(carNames);
    }

    @Override
    public int getRounds() {
        // TODO: 사용자에게 출력할 메시지를 담고 있는 별도 클래스 생성
        System.out.println("시도할 횟수는 몇 회인가요?");
        // TODO: 숫자가 아닌 값을 입력한 경우에 대한 예외 처리
        return scanner.nextInt();
    }
}
