package racinggame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        int carSize = inputView.carSize();
        int racingCount = inputView.racingCount();

        new RacingGame().racing(carSize, racingCount);
    }

}
