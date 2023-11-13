package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {

    private static final String DISPLAY_TEST = "-";

    private static final String WINNER = "가 최종 우승했습니다.";

    public static void viewResultView(Cars resultList) {

        for(int i=0; i<resultList.getSize(); i++){
            System.out.println(intFormatString(resultList.getCar(i).getCarName(), resultList.getCar(i).getMoveCount()));
        }
        System.out.println();
    }

    private static String intFormatString(String carName, int count){
        return carName+":"+DISPLAY_TEST.repeat(count);
    }

    public static void winnerView(String winner){
        System.out.println(winner+WINNER);
    }
}
