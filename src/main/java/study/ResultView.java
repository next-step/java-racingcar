package study;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String MOVE_SIGN = "-";

    public void racingResult(List<Car> carList){
        System.out.println(RESULT_MESSAGE);
        for (Car car :carList){
            for (int i = 0; i < car.getMoveCount(); i++) {
                System.out.print(MOVE_SIGN);
            }
            System.out.println();
        }

    }
}
