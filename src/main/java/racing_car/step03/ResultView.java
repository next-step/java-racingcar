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

    private static void printResultContents(Car car){
        for (int i=0; i<car.getDrivingDistance(); i++){
            System.out.print(DISTANCE_SYMBOL);
        }
    }
}
