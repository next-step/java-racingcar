package view;

import domain.Car;
import domain.RacingGame;

import java.util.List;

public class ResultView {

    public static void watchRace(RacingGame racingGame){
        System.out.println("실행결과");
        for (int i = 0 ; i < racingGame.getTime(); i++){
            watchTrace(racingGame.move());
        }
    }

    private static List<Car> watchTrace(List<Car> cars) {
        for(int j =0; j < cars.size(); j++){
            printName(cars.get(j));
            drawTrace(cars.get(j));
        }
        System.out.println();
        return cars;
    }

    private static void printName(Car car) {
        System.out.print(car.getName() +" : ");
    }

    private static void drawTrace(Car car) {
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < car.getPosition(); k++) {
           sb.append("-");
        }
        System.out.println(sb.toString());
    }

}
