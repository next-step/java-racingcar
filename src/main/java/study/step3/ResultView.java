package study.step3;

import java.util.List;

public class ResultView {
    public static void output(List<Car> cars){
        for(Car car : cars){
            int position = car.move();
            printPosition(position);
        }
    }
    public static void printPosition(int position){
        for(int i=0;i<position;i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
