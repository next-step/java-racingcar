package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private NumberBox numberBox = new GameNumberBox();

    private static final int PIVOT_NUMBER_TO_FORWARD = 4;
    private static final int NUMBER_TO_GET_RANDOM_NUMBER = 10;

    private final int carCount;
    private final int gameCount;

    public RacingCarGame(int inputCarCount, int inputGameCount){
        carCount = inputCarCount;
        gameCount = inputGameCount;
    }

    public  List<String> play(){

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
        return  numberBox.getRandomInt(NUMBER_TO_GET_RANDOM_NUMBER) >= PIVOT_NUMBER_TO_FORWARD;
    }

    private List<Car> carList() {
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carCount; i++){
            carList.add(new Car());
        }
        return carList;
    }

}
