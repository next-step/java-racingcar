package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingGame {
    private Random random = new Random();
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
        for(int index = 0; index < this.tryCount; index++){
            doRacing();
        }
    }

    private void doRacing(){
        this.carEntryList
                .forEach(vo->vo.move(random.nextInt(10)));
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
