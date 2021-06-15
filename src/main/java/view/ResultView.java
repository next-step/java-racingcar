package view;

import domain.Car;
import static domain.CarConstant.*;

import java.util.List;

public class ResultView {

    public static void printCars(List<Car> cars) {
        for(Car car : cars){
            System.out.println(car.getCarName() + " : " + printMoveRegex(car));
        }
        System.out.println();
    }

    private static String printMoveRegex(Car car) {
        StringBuilder regex = new StringBuilder();

        for(int i = 0; i < car.getPosition(); i++){
            regex.append(MOVE_REGEX_HYPHEN);
        }
        return regex.toString();
    }

    public static void printWinners(String winners) {
        System.out.println("실행 결과");
        System.out.println("최종우승자 : " + winners);
    }
}
