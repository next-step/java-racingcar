package racing.view;

import racing.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String MOVING = "-";

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printNewLine(){
        System.out.println();
    }

    public static void printPosition(Car car){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<car.getPosition(); i++){
            builder.append(MOVING);
        }
        System.out.println(builder);
    }

    public static void printPositionList(List<Car> carList){
        for(Car car: carList) printPosition(car);
    }
}
