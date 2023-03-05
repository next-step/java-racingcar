package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing{
    private List<RacingCar> list;
    private Map<RacingCar, Integer> rankMap;

    public Racing(String[] racingCars){
        list = new ArrayList<>();
        for(String racingCarName : racingCars){
            RacingCar racingCar = new RacingCar(racingCarName);
            list.add(racingCar);
        }
    }

    public void run(int tryCount){
        System.out.println("실행 결과");
        int tryCountStart = 0;
        while(tryCountStart < tryCount){
            for(RacingCar racingCar : list){
                racingCar.run();
                racingCar.print();
            }
            tryCountStart++;
            System.out.println();
        }
    }
}
