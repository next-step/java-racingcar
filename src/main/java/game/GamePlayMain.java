package game;

import racing.MessageBox;

import java.util.Scanner;

public class GamePlayMain {

    private static final String FIRST_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String SECOND_REQUEST = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        MessageBox messageBox = new MessageBox();
        GamePlay gamePlay = new GamePlay(messageBox);
        Scanner scanner = new Scanner(System.in);

        messageBox.commonMessageBox(FIRST_REQUEST);
        gamePlay.createPlayer(scanner.next());

        messageBox.commonMessageBox(SECOND_REQUEST);
        gamePlay.playingGame(scanner.next());

        scanner.close();
    }
}
