package racingcar;

import java.util.List;

public class ResultView {

    public static void printResult(Race race, int loop){
        System.out.println("실행결과");
        for(int i = 0 ; i < loop ; i++){
            race.round();
            printStatus(race.getCars());
        }
    }

    private static void printStatus(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getStatus());
        }
        System.out.println();
    }
}
