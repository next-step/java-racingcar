package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.view.ResultView.*;

public class Racing {
    private List<Car> carList = new ArrayList<>();
    private final NumberGenerator numberGenerator = new RandomGenerator();

    public Racing(int carCount){
        for(int i=0; i<carCount; i++){
            carList.add(new Car());
        }
    }

    public void race(int tryCount){
        printResultMessage();
        for(int i=0; i<tryCount; i++){
            roundStart();
        }
    }

    public void roundStart(){
        for(Car car : carList){
            car.turn(numberGenerator);
        }
        print();
    }

    public void print(){
        printPositionList(carList);
        printNewLine();
    }
}
