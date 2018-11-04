package racing.ui;

import racing.Messages;
import racing.domain.RacingCar;

import java.util.List;

public class RacingResultView {
    private static final String SEPARATOR = "-";
    private static final String RACING_CAR_PROGRESS_FORMAT = "%10s : %s";

    static {
        System.out.println(Messages.RACING_RESULT);
    }

    public static void render(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(String.format(RACING_CAR_PROGRESS_FORMAT, car.getName(), makeRacingProgress(car.getCurrentPosition())));
        }
        System.out.println();
    }

    private static String makeRacingProgress(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(SEPARATOR);
        }
        return sb.toString();
    }
}
