package racing;

import java.util.List;

public class ResultView {

    static String DISPLAY_TEST = "-";

    public static void viewResultView(List<Car> carList) {
        for(Car car : carList){
            System.out.println(intFormatString(car.moveCount));
        }
        System.out.println();
    }

    private static String intFormatString(int count){
        return DISPLAY_TEST.repeat(count);
    }

}
