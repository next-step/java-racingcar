package racing.view;


import racing.RacingCar;
import racing.RacingCarList;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    static String RACING_STATE_EXPRESSION = "-";
    static String COMMA = ",";


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
        System.out.print(racingCar.getName() + " : ");
        for(int i=0;i<=sumOfRacingLength;i++) {

            System.out.print(RACING_STATE_EXPRESSION);
        }
        System.out.println();
    }

    public static void viewRacingResult(RacingCarList racingCarList) {
        viewRacingResult(racingCarList.getRecingCarList());
        viewRacingWinner(racingCarList);
    }

    private static void viewRacingWinner(RacingCarList racingCarList) {
        ArrayList<String> winnerList = racingCarList.getCarsOfWinnerName();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<winnerList.size();i++) {
            sb.append(winnerList.get(i));
            if(i != winnerList.size()-1) {
                sb.append(COMMA);
            }
        }
        sb.append("가 최종 우승하였습니다.");
        System.out.println(sb.toString());
    }
}
