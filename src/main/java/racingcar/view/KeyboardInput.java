package racingcar.view;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class KeyboardInput implements Input {
    private final InputStream source;

    public KeyboardInput(InputStream source) {
        this.source = source;
    }

    @Override
    public List<String> getCarNames() {
        // TODO: 중복된 이름이 존재하는 경우에 대한 예외 처리
        Scanner scanner = new Scanner(this.source);
        String carNames = scanner.nextLine();
        return InputParser.parseCarNames(carNames);
    }

    @Override
    public int getRounds() {
        Scanner scanner = new Scanner(this.source);
        return scanner.nextInt();
    }
}
