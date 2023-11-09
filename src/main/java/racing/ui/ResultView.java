package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {

    static private String DISPLAY_TEST = "-";

    public static void viewResultView(Cars resultList) {

        for(int i=0; i<resultList.getSize(); i++){
            System.out.println(intFormatString(resultList.getCar(i).getMoveCount()));
        }
        System.out.println();
    }

    private static String intFormatString(int count){
        return DISPLAY_TEST.repeat(count);
    }
}
