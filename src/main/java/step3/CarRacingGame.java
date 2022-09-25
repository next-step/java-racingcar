package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private Integer numberOfCar;
    private Integer tryCount;
    private List<Car> carEntryList;

    CarRacingGame(int numberOfCar, int tryCount){
        this.numberOfCar = numberOfCar;
        this.tryCount = tryCount;
    }

    // 게임 시작
    public void doGame(){
        readyToCarEntry();
    }

    private void readyToCarEntry(){
        this.carEntryList = new ArrayList<>();
        for(int index = 0; index < numberOfCar; index++){
            this.carEntryList.add(new Car(index));
        }
    }

    // 테스트용
    public Integer getCarEntrySize(){
        return this.carEntryList.size();
    }
}
