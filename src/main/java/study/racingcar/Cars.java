package study.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public static Cars from(List<Car> carList) {
        return new Cars(carList);
    }

    public int numberOfCar() {
        return carList.size();
    }

    public List<Car> carlist(){
        return carList;
    }

}
