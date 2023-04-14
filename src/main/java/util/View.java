package util;

import entity.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class View {

    public static void printRound(int count){
        System.out.println();
        System.out.println(count + "회차");
    }

    public static void printRecord(Car car, int record){
        System.out.print(car.getNameValue() + " : ");
        for(int j=0; j<record; j++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners){
        String winner = String.join(", ", winners);
        System.out.print(winner);
        System.out.println(" 가 최종 우승했습니다.");
    }
}
