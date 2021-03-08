package study.step3;

import java.util.List;

public class ResultView {
    public static void output(Cars carList){
        carList.move();
        printPosition(carList.getCars());
    }
    public static void printPosition(List<Car> cars){
        for(Car car : cars){
            RandomRaceCar randomRaceCar = (RandomRaceCar)car;
            printRandomRaceCarPosition(randomRaceCar.getPosition());
        }
    }
    public static void printRandomRaceCarPosition(int position){
        for(int i=0;i<position;i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
