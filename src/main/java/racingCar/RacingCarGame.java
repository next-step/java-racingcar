package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {

    private static final int PIVOT_NUMBER_TO_FORWARD = 4;
    private static final int CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO = 10;

    private static int carCount;
    private static int gameCount;

    public  List<String> play(int inputCarCount, int inputGameCount){
        carCount = inputCarCount;
        gameCount = inputGameCount;

        inputCheck(carCount, gameCount);

        List<Car> carList = carList();

        playing(carList);

        return carList.stream().map(Car::toString).collect(Collectors.toList());
    }

    private void inputCheck(int carCount, int gameCount) {
        if(carCount <= 0){
            throw new IllegalArgumentException("자동차 대수는 0보다 큰 수를 입력해야합니다.");
        }
        if(gameCount <= 0){
            throw new IllegalArgumentException("시도할 횟수는 0보다 큰 수를 입력해야합니다.");
        }
    }


    private void playing(List<Car> carList) {
        for(int i=0; i<gameCount; i++){
            playEachCar(carList);
        }
    }

    private void playEachCar(List<Car> carList) {
        carList.forEach(a->{
            if (isSatisfiedForward()) {
                a.forward();
            }
        });
    }

    private boolean isSatisfiedForward(){
        return new Random().nextInt(CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO) >= PIVOT_NUMBER_TO_FORWARD;
    }

    private List<Car> carList() {
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCount; i++){
            carList.add(new Car());
        }
        return carList;
    }

}
