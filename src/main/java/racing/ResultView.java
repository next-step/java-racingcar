package racing;

public class ResultView {

    public static final char DISPLAY_CHARACTER = '-';

    public static String display(RacingCar[] racingCars) {
        StringBuilder builder = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            builder.append(display(racingCar.getTotalForwardCounts()));
            builder.append('\n');
        }
        builder.append('\n');

        String result = builder.toString();
        System.out.print(result);
        return result;
    }

    private static String display(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(DISPLAY_CHARACTER);
        }
        return builder.toString();
    }
}
