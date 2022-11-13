package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> carList;

    public Cars(final List<Car>carList){
        this.carList=carList;
        if(!duplicateNameCheck(this.carList)){
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public boolean duplicateNameCheck(List<Car> cars){
        return  cars.stream()
                .map(Car::getName)
                .distinct()
                .count() == cars.size();
    }

    public void racing(NumberGenerator numberGenerator){
        carList.forEach(car -> car.move(numberGenerator));
    }

    public List<Car> getWinners() {
        List<Car> winnerList = new ArrayList<>();

        int maxPosition = getMaxPosition();

        carList.forEach(car -> {
            if (car.samePosition(maxPosition))
                winnerList.add(car);
        });
        return winnerList;
    }

    private int getMaxPosition() {
        return carList.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
