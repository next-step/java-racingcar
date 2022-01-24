package racinggame.domain;

import java.util.List;
import java.util.Scanner;

public class GameInit {


    public String[] inputPlayerName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String playerNames = "";
        String[] playerNameList;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            playerNames = scanner.nextLine();
            playerNameList = playerNames.split(",");
            boolean isValidate = validationStringLength(playerNameList);
            if (isValidate == true) {
                break;
            }
        }
        return playerNameList;
    }

    public int inputTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public boolean validationStringLength(String[] playerNameList) {
        boolean isValidate = true;
        for (String playerName : playerNameList) {
            if (playerName.length() > 5) {
                System.out.println("자동차의 이름은 5자를 초과할 수 없습니다.");
                isValidate = false;
            }
        }
        return isValidate;
    }

}
