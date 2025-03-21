package step4.racingcar2.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public ArrayList<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).)");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        return new ArrayList<>(Arrays.asList(names));
    }

    public int getNumberOfRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

}
