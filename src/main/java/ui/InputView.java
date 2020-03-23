package ui;

import domain.GameRole;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameRole getGameRole() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = scanner.next();
        List<String> names = Arrays.asList(inputName.split(","));
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numberOfAttempts = scanner.nextInt();

        return new GameRole(names, numberOfAttempts);
    }

}
