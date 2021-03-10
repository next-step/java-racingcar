package study.step3;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    public static void main(String[] args){
        String[] carNames = InputView.getCarsName();
        List<Car> carList = new ArrayList<>();
        for(String carName : carNames){
            carList.add(new RandomRaceCar(carName));
        }
        Cars cars = new Cars(carList);
        int tryCnt = InputView.getTryCnt();
        System.out.println("실행 결과");
        for(int i=0;i<tryCnt;i++){
            ResultView.output(cars);
            System.out.println();
        }
        for(Car winner : cars.getWinners()){
            System.out.print(winner.getCarName()+", ");
        }
        System.out.println("가 최종우승했습니다.");
    }
}

