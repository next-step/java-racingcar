package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputRenderer {

    public static void printRaceStatus(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(String winners){
        System.out.println("최종 우승자 : " + winners);
    }

    public static void printError(String message){
        System.out.println("[ERROR]: " + message);
    }
}
