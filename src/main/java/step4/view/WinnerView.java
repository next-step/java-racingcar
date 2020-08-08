package step4.view;

import step4.dto.Car;

import java.util.List;

import static step4.TextConstant.TEXT_SHOW_WINNER;

public class WinnerView {

    private final String SEPERATOR_WINNER_NAME = ", ";

    public void racingResult(List<Car> winnerInRaceResult){
        showWinner(winnerInRaceResult);
    }

    private void showWinner(List<Car> winnerInRaceResult){
        StringBuilder winnerList = new StringBuilder();

        for(Car car : winnerInRaceResult){
            winnerList.append(car.name()).append(SEPERATOR_WINNER_NAME);
        }

        String winnersString = removeLastSeperator(winnerList.toString());

        System.out.println(winnersString + TEXT_SHOW_WINNER);
    }

    private String removeLastSeperator(String winnersString){
        int lastSeperatorIndex = winnersString.length() - SEPERATOR_WINNER_NAME.length();
        return winnersString.substring(0, lastSeperatorIndex);
    }
}
