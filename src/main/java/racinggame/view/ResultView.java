package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.RacingResult;

import java.util.List;

public class ResultView {
    static final String RESULT_TITLE = "\n실행 결과";
    static final String POSITION_STRING = "-";
    static final String WINNING_MESSAGE = "이(가) 최종 우승했습니다.";
    static final String WINNER_SEPARATOR = ",";

    public void showResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void showCarPositions(RacingResult result) {
        for( Car curCar : result.getCars() ) {
            showCarPosition(curCar);
        }
        System.out.println();
    }

    void showCarPosition(Car car) {
        System.out.print(car.getName() + " : " );
        for( int i = 0; i < car.getPosition(); ++i ) {
            System.out.print(POSITION_STRING);
        }
        System.out.println();
    }

    public void showWinners(RacingResult result) {
        System.out.println(getWinnersString(result) + WINNING_MESSAGE);
    }

    String getWinnersString(RacingResult result) {

        StringBuilder sb = new StringBuilder();
        List<Car> winners = result.getWinners();

        int lastItemIndex = winners.size() - 1;

        for( int i = 0; i < lastItemIndex; ++i ) {
            sb.append(winners.get(i).getName() + WINNER_SEPARATOR);
        }
        sb.append(winners.get(lastItemIndex).getName());

        return sb.toString();
    }
}