package racing;

import java.util.List;

public class ResultView {
    public static final String RACE_START = "\n🏁 Race Start! 🏁";
    public static final String RACE_FINISHED = "\n🏆 Race Finished! 🏆";
    public static final String CAR_POSITION_PROGRESS = "-";

    public static void displayCar(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(CAR_POSITION_PROGRESS.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void displayRaceStart() {
        System.out.println(RACE_START);
    }

    public static void displayRaceFinish() {
        System.out.println(RACE_FINISHED);
    }
}
