package racinggame;

import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        int carSize = inputView.carSize();
        int racingCount = inputView.racingCount();
    }

}
