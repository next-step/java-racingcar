package racing;

public class ResultView {
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String CAR_SYMBOL = "-";

    public static void printResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printRacingStatus(Cars cars) {
        cars.getCars().forEach(car -> {
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print(CAR_SYMBOL);
            }
            printLineBreak();
        });
    }

    public static void printLineBreak() {
        System.out.println();
    }
}
