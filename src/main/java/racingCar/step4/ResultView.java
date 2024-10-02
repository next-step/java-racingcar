package racingCar.step4;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String STATE_PRINT_FORMAT = "-";
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final String CHAMPION_PRINT_FORMAT = "%s가 최종 우승했습니다.";

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(Car[] cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        endRace();
    }

    public static void printRaceChampion(List<Car> championCars) {
        String championName = String.join(CAR_NAME_SEPARATOR, getChampionCarNames(championCars));
        System.out.format(CHAMPION_PRINT_FORMAT, championName);
    }

    private static void printCarPosition(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s : ", car.getName()));
        sb.append(STATE_PRINT_FORMAT);

        for(int i = 0; i< car.getPosition(); i++){
            sb.append(STATE_PRINT_FORMAT);
        }
        System.out.println(sb.toString());
    }

    private static void endRace() {
        System.out.println();
    }

    private static List<String> getChampionCarNames(List<Car> championCars) {
        List<String> championCarNames = new ArrayList<>();
        for (Car car : championCars) {
            championCarNames.add(car.getName());
        }
        return championCarNames;
    }
}
