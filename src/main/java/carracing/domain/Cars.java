package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(List<Name> carNames) {
        for(int i=0; i<carNames.size();i++){
            carList.add(new Car(carNames.get(i)));
        }
    }

    public Cars(List<Name> carNames, int position) {
        for(int i=0; i<carNames.size();i++){
            carList.add(new Car(carNames.get(i),position));
        }
    }

    public List<Car> getCarList() {
        return carList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(carList, cars.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList);
    }
}
