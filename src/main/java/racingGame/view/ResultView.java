package racingGame.view;

import racingGame.domain.Car;
import racingGame.domain.Cars;

public class ResultView {

    private static final String MOVE_SIGN = "-";
    private static final String RESULT_MESSAGE = "실행결과";

    public static void resultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void racingResult(Cars cars){
        for(Car car : cars.getCars()){
            printCarMove(car);
        }
        System.out.println();
    }

    private static void printCarMove(Car car) {
        System.out.println(carMoveStatus(car.getMoveCount()));
    }

    private static String carMoveStatus(int position) {
        StringBuffer sb = new StringBuffer();
        sb.append(MOVE_SIGN.repeat(position));
        return sb.toString();
    }
}
