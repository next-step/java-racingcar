package racinggame;

public class OutputView {

    private OutputView() {

    }

    public static void printRace(Race race, int rounds) {
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            race.run(1);
            printCars(race);
            System.out.println();
        }
    }

    private static void printCars(Race race) {
        for (Car car : race.cars()) {
            System.out.println("-".repeat(car.position()));
        }
    }
}
