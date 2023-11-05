package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        List<Car> carList = new ArrayList<>();
        for(int i=0; i<CAR_COUNT; i++){
            carList.add(new Car());
        }

        for(int i=0; i<GAME_COUNT; i++){
            for(Car car: carList){
                if(isSatisfiedForward()){
                    car.forward();
                }
            }
        }

        List<String> distanceList = new ArrayList<>();
        for(Car car: carList){
            distanceList.add(car.distance());
        }
        new ResultView(distanceList).printResult();

    }

    private boolean isSatisfiedForward(){
        return new Random().nextInt(CLOSED_END_NUMBER_TO_GET_RANDOM_NUMBER_FROM_ZERO) >= PIVOT_NUMBER_TO_FORWARD;
    }

}
