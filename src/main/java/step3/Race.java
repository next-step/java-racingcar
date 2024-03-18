package step3;


import step3.object.Car;
import step3.util.NumberGenerator;
import step3.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public List<Car> generateCarList(List<String> carNameList){
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void startMoving(List<Car> carList){
        for (Car car : carList) {
            int chance = numberGenerator.generate();
            car.move(chance);
        }
    }

    public List<Car> findWinnerList(List<Car> carList) {

        //Stream 함수 사용
//        int maxPosition = carList.stream()
//                .mapToInt(Car::getPosition)
//                .max()
//                .getAsInt();
//
//        List<Car> winnerList = carList.stream()
//                .filter(car -> car.getPosition() == maxPosition)
//                .collect(Collectors.toList());

        int maxPosition = getMaxPosition(carList);
        List<Car> winnerList = new ArrayList<>();
        for (Car car : carList)
            winnerList = addWinner(winnerList, car, maxPosition);

        return winnerList;

    }

    private List<Car> addWinner(List<Car> winnerList, Car car, int maxPosition){
        if (car.getPosition() == maxPosition) {
            winnerList.add(car);
        }
        return winnerList;
    }

    private int getMaxPosition(List<Car> carList){
        int maxPosition = 0;
        for (Car car : carList)
            maxPosition = Math.max(maxPosition, car.getPosition());
        return maxPosition;
    }
}