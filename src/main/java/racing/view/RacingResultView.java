package racing.view;

import racing.Messages;
import racing.domain.RacingCar;

import java.util.Arrays;
import java.util.List;

public class RacingResultView {
    private static final String SEPARATOR = "-";

    static {
        System.out.println(Messages.RACING_GAME_RESULT);
    }

    public static void renderGameProgress(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(String.format(Messages.RACING_GAME_PROGRESS, car.getName(), makeRacingCarProgress(car.getCurrentPosition())));
        }
        System.out.println();
    }

    private static String makeRacingCarProgress(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(SEPARATOR);
        }
        return sb.toString();
    }

    public static void renderWinner(String[] winners) {
        System.out.println(String.format(Messages.RACING_GAME_WINNERS, Arrays.toString(winners)));
    }
}
