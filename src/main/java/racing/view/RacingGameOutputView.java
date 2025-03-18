package racing.view;

import racing.entity.Car;
import racing.entity.RacingCars;
import racing.message.GameMessage;

import java.util.List;

public class RacingGameOutputView {
    private static final String DASH = "-";

    public static void printHeadOfOutputMessage() {
        System.out.println(GameMessage.HEAD_OF_OUTPUT_MESSAGE.getGameMessage());
    }

    public static void printRoundResult(RacingCars racingCars) {
        List<Car> cars = racingCars.getCars();

        for (Car car : cars) {
            printCarInfo(car);
        }
        System.out.println();
    }

    public static void printRacingGameWinners(List<String> winners) {
        String winnersNames = String.join(", ", winners);
        System.out.println(String.format(GameMessage.WINNERS_OUTPUT_MESSAGE.getGameMessage(), winnersNames));
    }

    private static void printCarInfo(Car car) {
        String carName = car.getCarName();
        int position = car.getPosition();

        System.out.println(String.format("%s : %s", carName, convertIntegerToSymbol(position, DASH)));
    }

    private static String convertIntegerToSymbol(int repeatCount, String symbol) {
        return symbol.repeat(repeatCount);
    }
}
