package race.vehicle;

import race.Utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Vehicles {
    private static final String INITIAL_LOCATION = "-";
    private final List<Car> list = new ArrayList<>();

    RandomGenerator randomGenerator = RandomGenerator.getRandomGenerator();

    public Vehicles(int num) {
        if(num < 2){
            throw new IllegalArgumentException("게임을 진행할 수 없음");
        }
        initList(num);
    }

    Vehicles initList(int num) {
        for (int i = 0; i < num; i++) {
            list.add(new Car.Builder().initlocation(INITIAL_LOCATION).initRandomUtil(randomGenerator).build());
        }
        return this;
    }

    public List<Car> getList() {
        return list;
    }
}
