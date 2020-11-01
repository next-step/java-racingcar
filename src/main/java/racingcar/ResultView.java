package racingcar;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    public static void print(List<Car> carList){
        for(int i=0; i < carList.size(); i++){
            System.out.println(carList.get(i).getDistance());
        }
        System.out.println();
    }
}
