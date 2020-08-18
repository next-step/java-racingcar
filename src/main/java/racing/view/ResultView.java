package racing.view;

import racing.RacingCar;

import java.util.List;

public class ResultView {

    static String RACING_STATE_EXPRESSION = "-";

    public static void viewRacingResult(List<RacingCar> racingResult) {

        int totalRacingRound = racingResult.get(0).racingResult.length;
        for(int i=1;i<=totalRacingRound;i++) {
            viewRacingRoundResult(i, racingResult);
        }
    }

    private static void viewRacingRoundResult(int racingRound, List<RacingCar> racingResult) {
        for(int i=0;i<racingResult.size();i++){
            viewRacingCarResult(racingRound, racingResult.get(i));
        }
        System.out.println();
    }


    private static void viewRacingCarResult(int racingRound, RacingCar racingCar) {
        racingCar.getRacingResult(racingRound);
        int sumOfRacingLength = 0;

        for(int i=1;i<=racingRound;i++) {
            sumOfRacingLength += racingCar.getRacingResult(i);
        }

        for(int i=0;i<=sumOfRacingLength;i++) {
            System.out.print(RACING_STATE_EXPRESSION);
        }
        System.out.println();
    }
}
