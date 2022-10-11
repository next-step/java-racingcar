package racingCar;

public class ResultView {

    public void printTitle() {
        System.out.println("실행 결과");
    }

    private void printCarDistance(RacingCar racingCar) {

        int carDistance = racingCar.distance();

        for (int distance = 0; distance < carDistance; distance++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public void printCarsDistance(RacingCar[] racingCars) {

        for (int carIndex = 0; carIndex < racingCars.length; carIndex++) {
            printCarDistance(racingCars[carIndex]);
        }

        System.out.println();
    }
}
