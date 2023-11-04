package step3;

import java.util.Scanner;

public class CarRacing {


    private static final ScannerInterface myScanner = new MyScanner(new Scanner(System.in));

    public static void main(String[] args) {

        InputView inputView = new InputView(myScanner);

        int carCount = inputView.setParticipantCarNumber();
        int racingChance = inputView.setRacingChance();



    }
}
