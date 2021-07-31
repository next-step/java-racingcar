package racing_winner.ui;

import racing_winner.domain.RacingCar;
import racing_winner.service.RacingService;

import java.util.List;

public class ResultView {

    private static final String RACING_RESULT_MESSAGE = "실행결과";
    private static final String RACING_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String RACING_SIGN = "-";
    private static final int INIT_NUMBER = 0;

    public void result(List<RacingCar> racingCarList, int round, int totalRound){
        if(round == INIT_NUMBER){
            System.out.println(RACING_RESULT_MESSAGE);
        }
        for (RacingCar racingCar : racingCarList){
            drawRacingResult(racingCar);
        }
        System.out.println();
        if(round == totalRound-1){
            selectWinner(racingCarList);
        }
    }

    public String drawDistance(RacingCar racingCar){
        String distanceLine = racingCar.racingNameTxt();
        int distance = racingCar.findFartherDistance(INIT_NUMBER);
        for(int i = 0; i < distance; i++){
            distanceLine += RACING_SIGN;
        }
        return distanceLine;
    }

    private void drawRacingResult(RacingCar racingCar) {
        System.out.println(drawDistance(racingCar));
    }

    private void selectWinner(List<RacingCar> racingCarList) {
        RacingService service = new RacingService();

        String name = service.findWinners(racingCarList);
        System.out.println(name + RACING_WINNER_MESSAGE);
    }
}
