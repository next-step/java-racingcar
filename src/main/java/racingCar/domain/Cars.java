package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final String SPLIT_DELIMITER = ",";
    private static final String SEPARATE_DELIMITER = " : ";
    private static final String FORWARD_MARK = "-";

    private List<Car> carList;

    public Cars(String carNames){
        carList = new ArrayList<>();
        String[] carNameArray = splitCarNames(carNames);

        for(int i=0; i<carNameArray.length; i++) {
            this.carList.add(new Car(carNameArray[i]));
        }
    }

    public Cars(int carCount){
        carList = new ArrayList<>();
        for(int i=0; i<carCount; i++){
            this.carList.add(new Car(0));
        }
    }

    public Cars(List<Car> carList){
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    private String[] splitCarNames(String carNames){
        return carNames.split(SPLIT_DELIMITER);
    }

    public List<String> repeatMove(int tryNum, RandomNumber randomNumber){
        List<String> allCarStatus = new ArrayList<>();

        for(int i = 0; i < tryNum; i++) {
            allCarStatus.addAll(addCarMoving(randomNumber));
            allCarStatus.add("");
        }

        return allCarStatus;
    }

    private List<String> addCarMoving(RandomNumber randomNumber) {
        List<String> carStatusList = new ArrayList<>();
        List<Integer> moves = randomNumber.generateRandomNumber(carList.size());

        for(int i = 0; i < carList.size();  i++){
            carList.get(i).moveCar(moves.get(i));
            carStatusList.add(carList.get(i).carStatus(SEPARATE_DELIMITER, FORWARD_MARK));
        }

        return carStatusList;
    }

    public Car findCar(String carName) {
        return carList.stream()
                .filter(car -> carName.equals(car.getCarName()))
                .findAny()
                .orElse(null);
    }
}
