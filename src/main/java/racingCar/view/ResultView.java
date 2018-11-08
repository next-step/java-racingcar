package racingCar.view;

import racingCar.Car;
import racingCar.domain.GameResult;

import java.util.List;

import static racingCar.Car.getNamesFromList;
import static racingCar.domain.GameResult.getWinnerList;

public class ResultView {

    //
    public static void print(GameResult gr){
        for(Car car : gr.getResultList()) {
            System.out.println(car.toString());
        }
        System.out.println();

    }

    public static void printWinner(GameResult gr){
        String result = "";
        List<String> winnerList = getNamesFromList(gr.getWinnerCar());
        result = getWinnerList(winnerList);

        System.out.println(result+ " 가 최종 우승했습니다.");

    }


}
