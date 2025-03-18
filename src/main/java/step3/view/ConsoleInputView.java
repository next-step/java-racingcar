package step3.view;

import step3.game.CarName;
import step3.game.PositiveNumber;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleInputView implements InputView {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public PositiveNumber carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new PositiveNumber(read());
    }

    @Override
    public PositiveNumber tryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return new PositiveNumber(read());
    }


    @Override
    public Set<CarName> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(",");

        Set<CarName> carNames = new HashSet<>();
        for (String name : names) {
            carNames.add(new CarName(name.trim()));
        }

        return carNames;
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
