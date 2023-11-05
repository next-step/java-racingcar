package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {

    private static final int PIVOT_NUMBER_TO_FORWARD = 4;
    private static final int CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO = 10;

    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";

    private int CAR_COUNT;
    private int GAME_COUNT;
    public void play(){
        CAR_COUNT = new InputView(CAR_COUNT_QUESTION).intInput();
        GAME_COUNT = new InputView(GAME_COUNT_QUESTION).intInput();

        inputCheck(CAR_COUNT, GAME_COUNT);

        List<Car> carList = carList();

        playing(carList);

        printResult(carList);

    }

    private void inputCheck(int carCount, int gameCount) {
        if(carCount <= 0){
            throw new IllegalArgumentException("자동차 대수는 0보다 큰 수를 입력해야합니다.");
        }
        if(gameCount <= 0){
            throw new IllegalArgumentException("시도할 횟수는 0보다 큰 수를 입력해야합니다.");
        }
    }

    private static void printResult(List<Car> carList) {
        List<String> distanceResultList = distanceResultList(carList);
        new ResultView(distanceResultList).printResult();
    }

    private static List<String> distanceResultList(List<Car> carList) {
        return carList.stream().map(Car::distance).collect(Collectors.toList());
    }

    private void playing(List<Car> carList) {
        for(int i=0; i<GAME_COUNT; i++){
            playEachCar(carList);
        }
    }

    private void playEachCar(List<Car> carList) {
        for(Car car: carList){
            forwardIfSatisfied(car);
        }
    }

    private void forwardIfSatisfied(Car car) {
        if(isSatisfiedForward()){
            car.forward();
        }
    }

    private List<Car> carList() {
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<CAR_COUNT; i++){
            carList.add(new Car());
        }
        return carList;
    }

    private boolean isSatisfiedForward(){
        return new Random().nextInt(CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO) >= PIVOT_NUMBER_TO_FORWARD;
    }

}
