package racingCar.step4;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String STATE_PRINT_FORMAT = "-";

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(Car[] cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        endRace();
    }

    private static void printCarPosition(Car car) {
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
}
