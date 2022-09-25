package step3;

import java.util.List;

public class ResultView {
    public void displayRacingState(List<Car> carList){
        System.out.println("게임 결과");
        carList
                .forEach(car-> System.out.println(car.getPositionString()));
    }
}
