package step3_racingCar;

import java.util.ArrayList;

public class Game {
    public static final String[] strs = {"자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?"};
    private final Cars racingCars;
    private final int tryNum;

    public Game(){
        ArrayList<Integer> inputArr = InputView.input(strs);
        racingCars = GameFactory.cars(inputArr.get(0));
        tryNum = inputArr.get(1);
    }

    public void start(){

    }
}
