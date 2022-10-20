package racingGame.view;

import racingGame.domain.Car;
import racingGame.domain.Cars;

public class ResultView {

    private static final String MOVE_SIGN = "-";
    private static final String RESULT_MESSAGE = "실행결과";

    private ResultView(){

    }

    public static void resultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void racingResult(Cars cars){
        for(Car car : cars.getCars()){
            System.out.println(carMoveStatus(car.getMoveCount()));
        }
        System.out.println();
    }

    private static String carMoveStatus(int move) {
        StringBuffer sb = new StringBuffer();
        sb.append(MOVE_SIGN.repeat(move));
        return sb.toString();
    }
}
