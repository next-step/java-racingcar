package racing_refactoring.ui;

import racing_refactoring.domain.Car;
import racing_refactoring.domain.RacingResult;

import java.util.List;

public class ResultView {

    private static final String RACING_RESULT_MESSAGE = "실행결과";
    private static final String RACING_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String RACING_SIGN = "-";
    private static final int INIT_NUMBER = 0;

    public void result(RacingResult racingResult, int trial, int round) {
        printResultMessage(trial);

        for (Car car : racingResult.getRoundResult()){
            drawDistance(car);
        }
        System.out.println();

        printWinnerMessage(racingResult, trial, round);
    }

    private void drawDistance(Car car){
        StringBuilder distanceLine = new StringBuilder(car.toString()).append(" : ");
        int distance = car.findFartherDistance(INIT_NUMBER);

        for(int length = 0; length < distance; length++){
            distanceLine.append(RACING_SIGN);
        }
        System.out.println(distanceLine);
    }

    private void printResultMessage(int round){
        if(round == INIT_NUMBER){
            System.out.println(RACING_RESULT_MESSAGE);
        }
    }
    private void printWinnerMessage(RacingResult racingResult, int trial, int round){
        if(trial == round-1){
            selectWinner(racingResult);
        }
    }

    private void selectWinner(RacingResult racingResult) {
        StringBuilder winnerName = new StringBuilder();

        List<Car> winners= racingResult.findWinners();
        for(Car car : winners){
            winnerName.append(", ").append(car.toString());
        }
        winnerName.delete(0,2);
        System.out.println(winnerName + RACING_WINNER_MESSAGE);
    }
}
