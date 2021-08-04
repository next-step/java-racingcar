package race.view;

import race.domain.Condition;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private static InputView inputView;

    public static synchronized InputView getInstance() {
        if (inputView == null) {
            return new InputView();
        }
        return inputView;
    }

    private InputView() {

    }

    public Condition operate() {
        return input();
    }

    private Condition input() {
        Scanner scanner = new Scanner(System.in);
        out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.next();
        String[] names = input.split(",");
        int carCount = names.length;
        out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return new Condition(carCount, tryCount, Arrays.asList(names));
    }

}
