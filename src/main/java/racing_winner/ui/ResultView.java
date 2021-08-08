package racing_winner.ui;

import racing_winner.domain.Car;
import racing_winner.domain.Racing;

import java.util.List;

public class ResultView {

    private static final String RACING_RESULT_MESSAGE = "실행결과";
    private static final String RACING_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String RACING_SIGN = "-";
    private static final int FIRST_ROUND = 0;

    public void result(int round, int totalRound, Racing racing){
        if(round == FIRST_ROUND){
            System.out.println(RACING_RESULT_MESSAGE);
        }

        for (Car car : racing.getRacingCar()){
            drawDistance(car);
        }
        System.out.println();

        if(round == totalRound-1){
            selectWinner(racing);
        }
    }
    public void drawDistance(Car car){
        StringBuilder distanceLine = new StringBuilder(car.getName()).append(" : ");
        int distance = car.getDistance();

        for(int i = 0; i < distance; i++){
            distanceLine.append(RACING_SIGN);
        }
        System.out.println(distanceLine);
    }

    private void selectWinner(Racing racing) {
        List<Car> winners= racing.findWinners();
        StringBuilder winnerName = new StringBuilder();

        for(Car car : winners){
            winnerName.append(", ").append(car.getName());
        }
        winnerName.delete(0,2);

        System.out.println(winnerName + RACING_WINNER_MESSAGE);
    }

}
