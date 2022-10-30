package racingGame.view;

import racingGame.domain.Car;
import racingGame.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String MOVE_SIGN = "-";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";
    private static final String SEPARATOR = ", ";
    private static final String CAR_NAME_SIGN = " : ";

    private ResultView(){

    }

    public static void resultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void racingWinner(Cars cars){
        String winnerName = String.join(SEPARATOR, cars.carWinner());
        System.out.println(winnerName + WINNER_MESSAGE);
    }

    public static void racingResult(Cars cars){
        for(Car car : cars.getCars()){
            System.out.print(car.getName() + CAR_NAME_SIGN);
            System.out.print(carMoveStatus(car.getMoveCount()));
            System.out.println();
        }
        System.out.println();
    }

    private static String carMoveStatus(int move) {
        StringBuffer sb = new StringBuffer();
        sb.append(MOVE_SIGN.repeat(move));
        return sb.toString();
    }

}
