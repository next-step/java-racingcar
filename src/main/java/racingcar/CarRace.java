package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private int tryCnt;
    List<Car> carList = new ArrayList<Car>();

    public CarRace(int carCnt, int tryCnt) {
        this.tryCnt = tryCnt;
        for(int i=0; i < carCnt; i++){
            carList.add(new Car());
        }
    }

    public void race(){
        for(int i=0; i < tryCnt; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).go();
                ResultView.print(carList.get(j));
            }
            System.out.println();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
