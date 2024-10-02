package racing;

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

    private static String display(RacingCar racingCar) {
        StringBuilder builder = new StringBuilder();
        if(racingCar.getName() != null){
            builder.append(String.format("%s : ", racingCar.getName()));
        }
        for (int i = 0; i < racingCar.getTotalForwardCounts(); i++) {
            builder.append(DISPLAY_CHARACTER);
        }
        return builder.toString();
    }
}
