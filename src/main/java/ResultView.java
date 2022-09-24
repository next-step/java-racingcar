public class ResultView {

    public static final String RESULT_MESSAGE_OF_GAME_END = "실행결과";
    public static final String DASH_STRING = "-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE_OF_GAME_END);
    }

    public static void printCarMovements(int[] cars) {
        for (int j = 0; j < cars.length; j++) {
            System.out.println(printDashByInt(cars[j]));
        }
        System.out.println();
    }

    public static String printDashByInt(int intVal) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= intVal; i++) {
            sb.append(DASH_STRING);
        }
        return sb.toString();
    }

}
