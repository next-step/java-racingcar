package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public void showResultMessage(){
        System.out.println("\n실행결과");
    }

    public void Result(List<Car> cars){
        int carNum = 0;
        for(Car car : cars){
            carNum += 1;
            int carLocation = car.carLocation();
            for(int i = 0; i <carLocation; i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
