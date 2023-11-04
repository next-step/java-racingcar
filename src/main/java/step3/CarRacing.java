package step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarRacing {


    private static final ScannerInterface myScanner = new MyScanner(new Scanner(System.in));

    public static void main(String[] args) {

        InputView inputView = new InputView(myScanner);
        ResultView resultView = new ResultView();

        int carCount = inputView.setParticipantCarNumber();
        int racingChance = inputView.setRacingChance();
        Map<Integer, Integer> racingBoard = setRacingBoard(carCount);


        System.out.println("실행 결과");

        CarRacingPlay carRacingPlay = new CarRacingPlay(new MyRandomValueGenerator());

        for (int i = 1; i <= racingChance; i++) {
            for (int carNumber = 1; carNumber <= carCount; carNumber++) {
                carRacingPlay.race(carNumber, racingBoard);
            }
            resultView.printRacingStatus(racingBoard);
            System.out.println();
        }
    }

    private static Map<Integer, Integer> setRacingBoard(int carCount) {
        Map<Integer, Integer> racingBoard = new HashMap<>();
        for (int carNumber = 1; carNumber <= carCount; carNumber++) {
            racingBoard.put(carNumber, 0);
        }
        return racingBoard;
    }
}
