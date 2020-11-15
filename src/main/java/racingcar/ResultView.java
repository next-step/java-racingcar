package racingcar;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void racingResult(List<Car> carList){
        for(int i = 0; i < carList.size(); i++){
            Car car = carList.get(i);
            for(int j = 0; j < car.getLocation(); j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}