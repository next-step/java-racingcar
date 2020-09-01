package racing.view;


import racing.controller.RacingGame;
import racing.domain.RacingCar;
import racing.domain.Winners;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    static String RACING_STATE_EXPRESSION = "-";
    static String COMMA = ",";


    public static void viewRacingScore(RacingGame racingGame) {

        racingGame.getCountOfRacing();

        int totalRacingRound = racingGame.getCountOfRacing();
        for(int i=1;i<=totalRacingRound;i++) {
            viewRacingRoundResult(i,   racingGame.getRacingCars().getRecingCarList());
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
        System.out.print(racingCar.getName() + " : ");
        for(int i=0;i<=sumOfRacingLength;i++) {

            System.out.print(RACING_STATE_EXPRESSION);
        }
        System.out.println();
    }

    public static void viewRacingResult(RacingGame racingGame) {

        viewRacingScore(racingGame);
        viewRacingWinner(racingGame);
    }

    private static void viewRacingWinner(RacingGame racingGame) {
        ArrayList<String> winnerList = Winners.getWinner(racingGame.getRacingCars());

        String result = winnerList.stream().collect(Collectors.joining(COMMA, "","가 최종 우승하였습니다."));

        System.out.println(result);
    }
}
