package CarRacing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ASK_CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
        String ASK_ATTEMPT_NUMBER = "시도할 회수는 몇 회 인가요?";

        ScannerView scannerView = new ScannerView();
        NumberInputScanner numberInputScanner = new NumberInputScanner();

        scannerView.textView(ASK_CAR_NUMBER);
        int carNumber = numberInputScanner.getNumber();

        scannerView.textView(ASK_ATTEMPT_NUMBER);
        int gameCount = numberInputScanner.getNumber();

        CarRacingGame carRacingGame = new CarRacingGame(new CarRacingOption(carNumber, gameCount));

        carRacingGame.gameStart();
    }
}
