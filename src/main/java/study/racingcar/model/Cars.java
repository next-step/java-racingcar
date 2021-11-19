package study.racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String SPLIT_RESULT_MESSAGE = " : ";
    private static final String END_RESULT_MESSAGE = "\n";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void startRound(){
        for (Car car : cars) {
            car.move();
        }
    }

    public String getResult(){
        String result = "";
        for (Car car : cars) {
            result += car.getName() + SPLIT_RESULT_MESSAGE + car.getLocation() + END_RESULT_MESSAGE;
        }
        return result;
    }

    public List<Car> getWinner() {
        return getWinners(maxPosition());
    }

    private int maxPosition() {
        int maxPosition = 0;
        for(Car car : cars){
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> getWinners(int maxPosition) {
        List<Car> winners = cars.stream()
                .filter(car -> car.isWinnerPosition(maxPosition))
                .collect(Collectors.toList());
        return winners;
    }


}
