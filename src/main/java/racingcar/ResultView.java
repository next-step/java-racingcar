package racingcar;

public class ResultView {
    public static void printRacingResult(Car car) {
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
