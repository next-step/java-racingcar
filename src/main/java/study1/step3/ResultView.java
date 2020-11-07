package study1.step3;

import java.util.List;

public class ResultView {
    public static void startRace(){
        System.out.println("실행 결과");
    }

    public static void show(List<Car> cars){
        for(Car car: cars){
            System.out.println(car.getMoveResult());
        }
        System.out.println("");
    }
}
