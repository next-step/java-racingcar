import java.util.List;

public class ResultView {
    public static void main(String... args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numOfCars = InputView.input();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int races = InputView.input();

        System.out.println("실행 결과");
        Cars cars = new Cars(numOfCars);

        raceResult(cars, races);
    }

    private static void raceResult(Cars cars, int races) {
        while (races > 0) {
            cars.move();
            outputCarsLocation(cars.distance());
            races--;
        }
    }

    private static void outputCarsLocation(List<Integer> carsLocation) {
        for (int distance : carsLocation) {
            while (distance > 0) {
                System.out.print("-");
                distance--;
            }
            System.out.println();
        }
        System.out.println();
    }
}
