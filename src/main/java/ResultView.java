import java.util.List;

public class ResultView {
    public static void main(String... args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numOfCars = InputView.inputInteger();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int races = InputView.inputInteger();

        System.out.println("실행 결과");
        RacingCars racingCars = new RacingCars(numOfCars);

        raceResult(racingCars, races);
    }

    private static void raceResult(RacingCars racingCars, int races) {
        while (races > 0) {
            racingCars.move();
            outputCarsLocation(racingCars.distance());
            races--;
        }
    }

    private static void outputCarsLocation(List<Integer> carsLocation) {
        for (int distance : carsLocation) {
            System.out.println(createCarDistanceBar(distance));
        }
        System.out.println();
    }

    private static String createCarDistanceBar(int distance) {
        StringBuilder stringBuilder = new StringBuilder();

        while (distance > 0) {
            stringBuilder.append("-");
            distance--;
        }

        return stringBuilder.toString();
    }
}