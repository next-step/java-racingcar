package CarRacing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ASK_CAR_NUMBER = "자동차 대수는 몇 대 인가요?";
        String ASK_ATTEMPT_NUMBER = "시도할 회수는 몇 회 인가요?";

        ScannerView scannerView = new ScannerView();

        scannerView.textView(ASK_CAR_NUMBER);
        NumberInputScanner carNumberScanner = new NumberInputScanner();

        scannerView.textView(ASK_ATTEMPT_NUMBER);
        NumberInputScanner gameCountScanner = new NumberInputScanner();

        CarRacingGame carRacingGame = new CarRacingGame(new CarRacingOption(carNumberScanner.getNumber(), gameCountScanner.getNumber()));

        carRacingGame.gameStart();
    }
}
