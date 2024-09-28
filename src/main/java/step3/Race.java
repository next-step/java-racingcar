package step3;

import java.util.List;

public class Race {
    private List<Car> carList;
    private int tryCount;

    public Race(List<Car> carList, int tryCount){
        this.carList=carList;
        this.tryCount=tryCount;
    }

    public int getTryCount(){
        return tryCount;
    }

    public List<Car> getCarList(){
        return carList;
    }
}
