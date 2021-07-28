package step5.domain;

import step5.domain.strategy.ArrangeStrategy;
import step5.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 일급 컬랙션
public class Cars {
    private final List<Car> carList;

    protected Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars from(List<Car> carList) {
        return new Cars(carList);
    }

    public static Cars from(int listSize) {
        Cars cars = new Cars(new ArrayList<Car>());
        cars.addCarListDefault(listSize);
        return cars;
    }
    public static Cars from(String[] names){
        Cars cars = new Cars(
                Arrays.asList(names).stream()
                        .map(name -> Car.from(name))
                        .collect(Collectors.toList())
        );
        return cars;
    }
    private void addCarListDefault(int listSize) {
        for (int idx = 0; idx < listSize; idx++) {
            this.carList.add(Car.from("car" + (idx + 1)));
        }
    }

    public List<Car> arrangeList(ArrangeStrategy strategy) {
        return strategy.arrangeCarList(this.carList);
    }

    public int getSize() {
        return this.carList.size();
    }

    public List<Car> move(MoveStrategy strategy){
        strategy.move(carList);
        return carList;
    }

}
