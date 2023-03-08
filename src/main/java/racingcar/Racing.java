package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing{
    private List<RacingCar> list;

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
                RacingCarPrinter.printNameAndRunCount(racingCar);
            }
            tryCountStart++;
            System.out.println();
        }
    }

    public List<RacingCar> getList(){
        return list;
    }
}
