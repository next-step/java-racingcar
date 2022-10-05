package study;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String MOVE_SIGN = "-";

    public void racingResult(Cars cars){
        System.out.println(RESULT_MESSAGE);
        for (Car car :cars.getList()){
            System.out.print(MOVE_SIGN.repeat(car.getMoveCount()));
            System.out.println();
        }
    }
}
