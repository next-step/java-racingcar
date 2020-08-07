package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> carList;

    public static Cars of(String names, int carCnt) {
        Random random = new Random();
        DiceRoller diceRoller = new DiceRollerImpl(random);
        String[] split = names.split(",");

        List<Car> carList = IntStream.range(0, carCnt).boxed()
                .map(e -> new Car(diceRoller, split[e]))
                .collect(Collectors.toList());

        return new Cars(carList);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Cars(List<Car> carList) {
        this.carList = carList;
    }



}
