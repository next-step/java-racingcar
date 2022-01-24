package racinggame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameInit {
    private static final String SEPARATOR = ",";
    private static final int MAX_LENGTH = 5;

    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            List<String> carNames = Arrays.asList(userInput.split(SEPARATOR));
            if (lessThanMaxLength(carNames)) {
                return carNames;
            }
        }
    }

    private boolean lessThanMaxLength (List<String> playerNameList) {
        for (String playerName : playerNameList) {
            if (playerName.length() > MAX_LENGTH) {
                System.out.println("[ERROR] 자동차의 이름은 5자를 초과할 수 없습니다.");
                return false;
            }
        }
        return true;
    }

    public int inputTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
