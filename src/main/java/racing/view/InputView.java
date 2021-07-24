package racing.view;

import racing.domain.Players;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PLAYERS_OF_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_OF_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String WRONG_NAME_LENGTH_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다. 게임을 다시 시작해주세요.";

    private InputView() {
    }

    public static Players inputPlayersOfCar() {
        System.out.println(INPUT_PLAYERS_OF_CAR);
        Players players = InputCarPlayer.createPlayers(scanner.nextLine());

        if (players.isEmpty()) {
            System.out.println(WRONG_NAME_LENGTH_MESSAGE);
            return inputPlayersOfCar();
        }

        return players;
    }

    public static int inputNumberOfCount() {
        System.out.println(INPUT_NUMBER_OF_COUNT);
        return getNextInt();
    }

    private static int getNextInt() {
        return scanner.nextInt();
    }
}
