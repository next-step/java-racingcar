package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Names;

public class ResultView {

    private static final String DASH = "-";
    private static final String MESSAGE_PLAYER_LOCATION = "%s : %s";
    private static final String MESSAGE_RACE_WINNER = "\n%s가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void currentRecord(Cars cars) {
        for (Car car : cars.getCars()) {
            locationResult(car);
        }
        System.out.println();
    }

    public static void locationResult(Car player) {
        StringBuilder racingRecord = new StringBuilder();
        for (int i = 0; i < player.getLocation().getLocation(); i++) {
            racingRecord.append(DASH);
        }
        System.out.print("\n" + String.format(MESSAGE_PLAYER_LOCATION, player.getName().getName(), racingRecord));
    }

    public static void awardRacing(Cars cars) {
        Names winners = cars.inFormWinners();
        System.out.print(String.format(MESSAGE_RACE_WINNER, winners.printNames()));
    }
}
