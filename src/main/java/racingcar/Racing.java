package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private int tryTime;
    private List<RacingCar> racingCars;

    public Racing(int carNum, int tryTime) {
        this.racingCars = new ArrayList<>(carNum);
        for(int i = 0; i < carNum; i++){
            racingCars.add(new RacingCar());
        }
        this.tryTime = tryTime;
    }

    public void startRace(){
        for(int i = 0; i < tryTime; i++) {
            moveCars();
       }
    }

    public void moveCars(){
        for(RacingCar racingCar: racingCars) {
            int random = generateRandomNum();
            racingCar.move(random);
        }
    }

    public static int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public static void main(String[] args) {
        int carNum = InputView.inputCarNum();
        int tryTime = InputView.inputTryTime();

        Racing r = new Racing(carNum, tryTime);
        r.startRace();

        ResultView resultView = new ResultView();
        resultView.printCars(r.getRacingCars());
    }
}
