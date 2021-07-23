package step3;

import java.util.Scanner;
import step3.domain.CarRacingGame;
import step3.ui.InputView;

public class Step3Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();

        inputView.askHowManyCars();
        int carCount = scanner.nextInt();

        inputView.askHowManyTryCounts();
        int tryCount = scanner.nextInt();

        scanner.close();

        System.out.println(new CarRacingGame(carCount, tryCount));

    }

}
