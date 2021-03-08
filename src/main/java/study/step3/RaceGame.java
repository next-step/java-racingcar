package study.step3;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    public static void main(String[] args){
        int carCnt = InputView.getCarCnt();
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCnt;i++){
            carList.add(new RandomRaceCar());
        }
        Cars cars = new Cars(carList);
        int tryCnt = InputView.getTryCnt();
        System.out.println("실행 결과");
        for(int i=0;i<tryCnt;i++){
            ResultView.output(cars);
            System.out.println();
        }
    }
}
