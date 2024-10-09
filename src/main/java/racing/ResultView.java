package racing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final char DISPLAY_CHARACTER = '-';

    public static String display(RacingCar[] racingCars) {
        StringBuilder builder = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            builder.append(display(racingCar));
            builder.append('\n');
        }
        builder.append('\n');

        String result = builder.toString();
        System.out.print(result);
        return result;
    }

    public static String display(RacingCarPosition[] positions) {
        StringBuilder builder = new StringBuilder();
        for (RacingCarPosition racingCar : positions) {
            builder.append(display(racingCar));
            builder.append('\n');
        }
        builder.append('\n');

        String result = builder.toString();
        System.out.print(result);
        return result;
    }

    private static String display(RacingCar racingCar) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < racingCar.getPosition().getCarPosition(); i++) {
            builder.append(DISPLAY_CHARACTER);
        }
        return builder.toString();
    }

    private static String display(RacingCarPosition position) {
        StringBuilder builder = new StringBuilder();
        if (position.getCarName() != null) {
            builder.append(String.format("%s : ", position.getCarName()));
        }
        for (int i = 0; i < position.getCarPosition(); i++) {
            builder.append(DISPLAY_CHARACTER);
        }
        return builder.toString();
    }

    public static String displayWinners(List<RacingCar> winners) {
        StringBuilder builder = new StringBuilder();
        builder.append(winners.stream().map(RacingCar::getName).collect(Collectors.joining(", ")));
        builder.append("가 최종 우승했습니다.");

        String result = builder.toString();
        System.out.println(result);
        return result;
    }
}
