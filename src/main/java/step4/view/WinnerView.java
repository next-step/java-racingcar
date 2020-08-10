package step4.view;

import step4.dto.Car;

import java.util.List;
import java.util.StringJoiner;

import static step4.TextConstant.TEXT_SHOW_WINNER;

public class WinnerView {

    private final String SEPERATOR_WINNER_NAME = ", ";

    public void racingResult(List<Car> winnerInRaceResult){
        showWinner(winnerInRaceResult);
    }

    private void showWinner(List<Car> winnerInRaceResult){
        StringJoiner joiner = new StringJoiner(SEPERATOR_WINNER_NAME);

        for(Car car : winnerInRaceResult){
            joiner.add(car.name());
        }

        System.out.println(joiner.toString() + TEXT_SHOW_WINNER);
    }
}
