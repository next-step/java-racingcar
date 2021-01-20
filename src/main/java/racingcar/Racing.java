package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    private ArrayList<Car> carsList;
    private int stages;

    public Racing(ArrayList<Car> carsList, int stages){
        this.carsList = carsList;
        this.stages = stages;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
