package racing_car.step03;

import java.util.List;

public class ResultView {
    private static final String MESSAGE = "실행 결과";
    private static final String DISTANCE_SYMBOL = "-";

    public static void printResultMessage(){

        System.out.println(MESSAGE);
    }

    public static void result(List<Car> cars) {
       for (int i=0; i<cars.size(); i++){
           printResultContents(cars.get(i));
       }
        System.out.println();
    }

    public static String printResultContents(Car car){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<car.getDrivingDistance(); i++){
            sb.append(DISTANCE_SYMBOL);
        }
        System.out.println(sb);
        return sb.toString();
    }
}
