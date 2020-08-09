package step4;

import step4.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class JudgeRacingResult {

    private JudgeRacingResult() {
    }

    public static List getWinnerInRaceResult(List<Car> entryList){
        int winnerPosition = getWinnerPosition(entryList);
        List<Car> winnerList = new ArrayList<>();

        for (Car car : entryList){
            addCarIfWinner(winnerList, winnerPosition, car);
        }

        return winnerList;
    }

    private static void addCarIfWinner(List<Car> winnerList, int winnerPosition, Car car ){
        if( winnerPosition == car.nowPosition()) winnerList.add(car);
    }

    private static int getWinnerPosition(List<Car> entryList){
        int winnerPosition = 0;

        for(Car car : entryList){
            winnerPosition = Math.max(winnerPosition,car.nowPosition());
        }

        return winnerPosition;
    }
}
