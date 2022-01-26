package racingcar;

public class Car {

    int[] cars;
    int times;
    String[] carNames;

    public void repeatGame() {
        while ((times--) > 0) {
            for (int i = 0; i < cars.length; i++) {
                int randomNumber = Race.getRandomNumber();
                Race.compareWithFour(cars, i, randomNumber);
            }
            OutputView.printCurrent(carNames, cars);
            System.out.println();
        }
    }
}
