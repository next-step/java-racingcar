package ui;

import domain.GameRole;

import java.util.*;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameRole getGameRole() {
        List<String> names = new ArrayList<>();
        int numberOfAttempts = 0;
        
        try {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String inputName = scanner.nextLine();
            names = Arrays.asList(inputName.split(","));
            System.out.println("시도할 횟수는 몇 회 인가요?");
            numberOfAttempts = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("잘못된 값을 입력하였습니다. 입력값을 확인해 주세요.");
            getGameRole();
        }

        return new GameRole(names, numberOfAttempts);
    }

}
