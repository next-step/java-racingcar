package racing_winner.ui;

import racing_winner.domain.RacingCar;
import racing_winner.service.RacingService;

import java.util.List;

public class ResultView {

    private static final String RACING_RESULT_MESSAGE = "실행결과";
    private static final String RACING_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String RACING_SIGN = "-";
    private static final int FIRST_ROUND = 0;

    public void result(List<RacingCar> racingCarList, int round, int totalRound){
        if(round == FIRST_ROUND){
            System.out.println(RACING_RESULT_MESSAGE);
        }
        for (RacingCar racingCar : racingCarList){
            getRacingResult(racingCar);
        }
        System.out.println();
        if(round == totalRound-1){
            printWinner(racingCarList);
        }
    }

    private void drawRacingResult(RacingCar racingCar) {
        System.out.println(racingCar.drawDistance(RACING_SIGN));
    }

    private void printWinner(List<RacingCar> racingCarList) {
        RacingService service = new RacingService();

        String name = service.findWinners(racingCarList);
        System.out.println(name + RACING_WINNER_MESSAGE);
    }
}
