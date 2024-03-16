package RacingCar.Controller;

import RacingCar.Model.Car;
import RacingCar.View.InputView;
import RacingCar.View.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarController {
    InputView inputView;
    ResultView resultView;
    List<Car> carList;
    int carCount;
    int roundCount;
    Random random;

    public RacingCarController() {
        inputView = new InputView();
        resultView = new ResultView();
        random = new Random();
        carCount = 0;
        roundCount = 0;
    }

    public void run() {
        startGame();
        setCarList();
        sayGameStart();
        playGame();
    }

    private void startGame() {
        carCount = inputView.getIntData("자동차 대수는 몇 대 인가요?");
        roundCount = inputView.getIntData("시도할 회수는 몇 회 인가요?");
    }

    private void setCarList() {
        carList = new ArrayList<>();
        for (int i=0; i<carCount; i++) {
            carList.add(new Car());
        }
    }

    private void sayGameStart() {
        resultView.printString("실행 결과");
    }

    private void playGame() {
        for (int round=0; round<=roundCount; round++) {
            playRound();
            String resultRound = resultRound();
            printRound(resultRound);
        }
    }

    private void playRound() {
        for (Car car : carList) {
            int boosterValue = random.nextInt(10);
            car.moveCar(boosterValue);
        }
    }

    private String resultRound() {
        String resultRound = "";
        for (Car car : carList) {
            String s = car.makeStringCurrentState();
            resultRound += s + "\n";
        }
        return resultRound;
    }

    private void printRound(String resultRound) {
        resultView.printString(resultRound);
    }
}
