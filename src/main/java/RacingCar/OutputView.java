package RacingCar;

public class OutputView {
    public void printTitle() {
        final String TITLE = "실행 결과";
        System.out.println();
        System.out.println(TITLE);
    }

    public void printSingleRacingResult(RacingResult racingResult) {
        for (int carIndex = 0; carIndex < racingResult.getNumberOfCars(); carIndex++) {
            int distance = racingResult.getDistance(carIndex);
            while (distance-- != 0) {
                System.out.print("-");
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }
}
