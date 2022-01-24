package racinggame.domain;

import java.util.Scanner;

public class GameInit {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LIMITED_LENGTH="자동차의 이름은 5자를 초과할 수 없습니다.";
    private static final String GAME_PLAY_NUMBER="시도할 횟수는 몇 회인가요?";
    private static final String GAME_INPUT_NAME="경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";


    public String[] inputPlayerName() {
        System.out.println(GAME_INPUT_NAME);
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
        System.out.println(GAME_PLAY_NUMBER);
        Scanner scanner = new Scanner(System.in);
        int tryNumber = scanner.nextInt();
        return tryNumber;
    }

    private boolean validationStringLength(String[] playerNameList) {
        boolean isValidate = true;
        for (String playerName : playerNameList) {
            if (playerName.length() > MAX_CAR_NAME_LENGTH) {
                System.out.println(CAR_NAME_LIMITED_LENGTH);
                isValidate = false;
            }
        }
        return isValidate;
    }

}
