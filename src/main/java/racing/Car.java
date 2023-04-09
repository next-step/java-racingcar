package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int position = 0;
    public static List<Car> createCarList(int totalCarNumber) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < totalCarNumber; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void move(int randomNumber) {
        if(randomNumber < 4){
            return;
        }
        position++;
    }

    public int valueOfPosition() {
        return position;
    }
}
