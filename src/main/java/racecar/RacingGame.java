package racecar;

import java.util.List;

public class RacingGame {
    private static final int WIN_CONDITION = 4;

    public static void main(String[] args) {

        int carCount = InputView.askNumberCount();
        int repeatCount = InputView.askRepeatCount();

        //자동차 생성
        Car.generate(carCount);
        List<Car> carList = Car.getCarList();

        //게임 실행
        RacingGame racingGame = new RacingGame();
        for (int i = 0; i < repeatCount; i++) {
            racingGame.run(carList);
            System.out.println("");
        }

    }

    public static boolean checkPass(int number) {
        boolean result = number >= WIN_CONDITION;
        return result;
    }

    public void run(List<Car> carList) {
        Randomizer randomizer = new Randomizer();
        for (Car car : carList) {
            int fuel = randomizer.generateNumber();
            car.move(fuel);
            ResultView.print(car);
        }
    }

}
