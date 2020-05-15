package step3;

import java.util.List;

public class RacingGame {
    final int WIN_CONDITION = 4;

    public static void main(String[] args) {
        // 입력
        InputView inputView = new InputView();
        inputView.initInput();
        int carCount = inputView.getCarCount();
        int repeatCount = inputView.getRepeatCount();

        // 레이싱 게임 초기화 - car 생성
        GameInitializer initializer = new GameInitializer();
        initializer.generateCar(carCount);
        List<Car> carList = initializer.getCarList();

        // 게임 실행, 결과 출력
        RacingGame racingGame = new RacingGame();
        ResultView resultView = new ResultView();

        for (int i = 0; i < repeatCount; i++) {
            racingGame.run(carList);
            resultView.print(carList);
        }
    }

    void run(List<Car> carList) {
        Randomizer randomizer = new Randomizer();
        for (Car car : carList) {
            int number = randomizer.generateNumber();
            if (checkPass(number))
                car.move();
        }
    }

    boolean checkPass(int number) {
        return number >= WIN_CONDITION;
    }
}
