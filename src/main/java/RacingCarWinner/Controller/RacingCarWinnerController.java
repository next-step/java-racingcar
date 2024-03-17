package RacingCarWinner.Controller;

import RacingCarWinner.Model.Car;
import RacingCarWinner.View.InputView;
import RacingCarWinner.View.ResultView;

import java.util.*;

public class RacingCarWinnerController {
    private static final String REGEX = ",";
    InputView inputView;
    ResultView resultView;

    List<Car> carList;
    String[] carNameList;
    int roundCount;
    Random random;

    public RacingCarWinnerController() {
        inputView = new InputView();
        resultView = new ResultView();
        random = new Random();
        roundCount = 0;
    }

    public void run() {
        startGame();
        setCarList();
        sayGameStart();
        playGame();
        sayGameWinner();
    }

    private void startGame() {
        String inputStringData = inputView.getStringData("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNameList = inputView.getSplitStringData(inputStringData, REGEX);
        roundCount = inputView.getIntData("시도할 회수는 몇 회 인가요?");
    }

    private void setCarList() {
        carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    private void sayGameStart() {
        resultView.printString("실행 결과");
    }

    private void playGame() {
        for (int round = 0; round <= roundCount; round++) {
            playRound();
            String resultRound = resultRound();
            printResult(resultRound);
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
            String stringCurrentPosition = car.makeStringCurrentPosition();
            resultRound += stringCurrentPosition + "\n";
        }
        return resultRound;
    }

    private void printResult(String result) {
        resultView.printString(result);
    }

    private void sayGameWinner() {
        String winners = getWinners(getFastCar());
        String resultGame = makeStringResultGame(winners);
        printResult(resultGame);
    }

    private Car getFastCar() {
        if (carList.size() == 0) {
            return null;
        }
        Collections.sort(carList);

        return carList.get(0);
    }

    private String getWinners(Car max) {
        StringBuilder winnerNames = new StringBuilder(max.getName());

        long winnerCount = carList.stream().filter(car -> car.getCurrentPosition() == max.getCurrentPosition()).count();
        for (int index = 1; index < winnerCount; index++) {
            winnerNames.append(REGEX).append(carList.get(index).getName());
        }
        return winnerNames.toString();
    }

    private String makeStringResultGame(String winners) {
        if (winners==null) {
            return "경주에 참여한 자동차가 없습니다.";
        }
        return winners + "가 최종 우승했습니다.";
    }
}
