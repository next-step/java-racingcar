package step3.view;

import step3.domain.Car;
import step3.domain.RacingGame;
import step3.lib.PrintMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameEmulator {

    private static final int PRINT_MIN_POSITION = 0;

    /**
     * 게임 결과를 출력한다.
     *
     * @param racingGame
     */
    public static void getResult(RacingGame racingGame) {
        while (racingGame.hasNextRace()) {
            racingGame.racing();
            showMeThePositions(racingGame.getListOfCarsUsed());
        }

        showMeTheChampions(racingGame.getListOfCarsUsed());
    }

    /**
     * 자동차 목록의 위치를 출력한다.
     *
     * @param cars
     */
    public static void showMeThePositions(List<Car> cars) {
        PrintMessage.println();
        for (Car car : cars) showMeThePosition(car);
    }

    /**
     * 현재 자동차의 위치를 출력한다.
     *
     * @param car
     */
    public static void showMeThePosition(Car car) {
        if (car.getCurrentPosition() <= PRINT_MIN_POSITION)
            return;

        PrintMessage.print("%s : ", car.getName());
        PrintMessage.print(getTailsOfCar(car));
        PrintMessage.println();
    }

    /**
     * 현재 자동차가 이동한 위치만큼의 "-" 문자값을 얻는다.
     *
     * @param car
     * @return
     */
    private static String getTailsOfCar(Car car) {
        return String.join("", IntStream.range(0, car.getCurrentPosition())
                .mapToObj(number -> "-")
                .collect(Collectors.toList())
        );
    }

    /**
     * 경기에서 우승한 자동차 목록을 반환한다.
     *
     * @return
     */
    public static List<Car> getChampions(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(-1);

        return cars.stream()
                .filter(car -> car.getCurrentPosition() == max)
                .collect(Collectors.toList());
    }

    /**
     * 경기에서 우승한 자동차 목록을 출력한다.
     *
     * @param cars
     */
    public static void showMeTheChampions(List<Car> cars) {
        PrintMessage.print(
                "\n%s 가 최종 우승했습니다.",
                String.join(", ",
                        getChampions(cars)
                                .stream()
                                .map(car -> car.getName())
                                .collect(Collectors.toList()))
        );
    }
}
