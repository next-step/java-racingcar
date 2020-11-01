package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    public static void main(String[] args){
        int carCnt = InputView.Input("자동차 대수는 몇 대 인가요? ");
        int tryCnt = InputView.Input("시도할 회수는 몇 회 인가요? ");
        race(carCnt, tryCnt);
    }

    public static void race(int carCnt, int tryCnt){
        List<Car> carList = new ArrayList<Car>();
        for(int i=0; i < carCnt; i++){
            carList.add(new Car());
        }
        System.out.println("\n실행결과");
        for(int i=0; i < tryCnt; i++) {
            for (int j = 0; j < carList.size(); j++) {
                carList.get(j).go();
            }
            ResultView.print(carList);
        }
    }
}
