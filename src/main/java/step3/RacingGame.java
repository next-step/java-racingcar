package step3;

import java.util.List;

public class RacingGame {
    final int WIN_CONDITION = 4;

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.initInput();
        int carCount = inputView.getCarCount();
        int repeatCount = inputView.getRepeatCount();

        CarGenerator generator = new CarGenerator();
        generator.generate(carCount);
        List<Car> carList = generator.getCarList();

        RacingGame racingGame = new RacingGame();
        for (int i = 0; i < repeatCount; i++) {
            racingGame.run(carList);
            ResultView.print(carList);
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
