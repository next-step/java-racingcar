package racingcar.printer;

import racingcar.domain.car.Car;

import java.util.List;

public class RacePrinter {

    private static String STATE = "-";

    public static void printRaceStart(){
        System.out.println("실행결과");
    }
    public static void printPerRound(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName()+" : "+STATE.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars){
        StringBuilder buffer = new StringBuilder();
        for(Car car : cars){
            buffer.append(car.getName());
            buffer.append(", ");
        }

        buffer.delete(buffer.length()-2, buffer.length()-1);
        System.out.println(buffer +"가 최종 우승하셨습니다.");
    }
}
