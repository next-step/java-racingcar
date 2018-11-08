package racingCar.View;

import racingCar.Car;
import racingCar.GameResult;

import java.util.List;

import static racingCar.Car.getNamesFromList;

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
        result += winnerList.get(0);
        for(int i=1; i<winnerList.size();i++){
            result += ", " + winnerList.get(i);
        }
        System.out.println(result+ " 가 최종 우승했습니다.");

    }


}
