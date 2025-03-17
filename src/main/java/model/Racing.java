package model;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList;
    private int tryCount;

    public Racing(int carCount, int tryCount) {
        this.tryCount = tryCount;

        carList = new ArrayList<>();
        for(int i = 0 ; i< carCount; i++){
            carList.add(new Car());
        }
    }

    public void start(){
        if(carList == null || carList.isEmpty()){
            throw new RuntimeException("")
        }

        if(tryCount = )
    }
}
