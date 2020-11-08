package racingcar;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    public static void print(Car car){
        for(int i=0; i < car.distance; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
