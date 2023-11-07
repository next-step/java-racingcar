package racing;

import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList = new ArrayList<>();

    public Racing(int carCount){
        for(int i=0; i<carCount; i++){
            carList.add(new Car());
        }
    }

    public void race(int tryCount){
        ResultView.printResultMessage();
        for(int i=0; i<tryCount; i++){
            roundStart();
        }
    }

    public void roundStart(){
        for(Car car : carList){
            car.turn(RandomGenerator.getNumber());
            ResultView.printString(car.drawPosition());
        }
        ResultView.printNewLine();
    }
}
