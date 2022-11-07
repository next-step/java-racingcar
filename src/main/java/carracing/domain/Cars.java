package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(List<Name> carNames) {
        if(!duplicateNameCheck(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
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

    public boolean duplicateNameCheck(List<Name> names){
        return  names.stream()
                .map(Name::toString)
                .distinct()
                .count() == names.size();
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
