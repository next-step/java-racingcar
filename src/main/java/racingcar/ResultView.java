package racingcar;

import java.util.List;

public class ResultView {

    public static void printResult(List<Car> cars){
        for(Car car: cars){
            printCarResult(car);
        }
    }

    public static void printCarResult(Car car){
        for(int i=0; i<car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResultMessage(){
        System.out.println("실행 결과");
    }
}
