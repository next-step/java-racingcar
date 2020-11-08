package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(int count){
        carList= new ArrayList<Car>();

        for(int i=0;i<count;i++){
            this.carList.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.carList;
    }
}
