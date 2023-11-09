package racingcar;

public class ResultView {
    public static void printRacingResult(Car car) {
        System.out.print(car.getName() + " : ");
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void printAsterisk() {
        System.out.println("*******************************************");
    }
}
