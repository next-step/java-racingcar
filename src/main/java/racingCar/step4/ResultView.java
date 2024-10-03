package racingCar.step4;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String STATE_PRINT_FORMAT = "-";
    private static final String CHAMPION_CAR_NAME_SEPARATOR = ",";
    private static final String CHAMPION_PRINT_FORMAT = "%s가 최종 우승했습니다.";

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(RacingCars cars) {
        for (RacingCar car : cars.getCars()) {
            printCarPosition(car);
        }
        endRace();
    }

    public static void printRaceChampion(List<RacingCar> championCars) {
        String championName = String.join(CHAMPION_CAR_NAME_SEPARATOR, getChampionCarNames(championCars));
        System.out.format(CHAMPION_PRINT_FORMAT, championName);
    }

    private static void printCarPosition(RacingCar car) {
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

    private static List<String> getChampionCarNames(List<RacingCar> championCars) {
        List<String> championCarNames = new ArrayList<>();
        for (RacingCar car : championCars) {
            championCarNames.add(car.getName());
        }
        return championCarNames;
    }
}
