package racingcar.view;

public class ResultView {
    private static String DISTANCE = "-";

    public static void printNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public static void printNumberOfMovements() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public static void printRacingResult() {
        System.out.println("실행 결과");
    }

    private static void printDistanceOfCar(int distance) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < distance; i++) {
            sb.append(DISTANCE);
        }

        System.out.println(sb);
    }

    public static void printStatusOfCars(int[] distances) {
        for(int distance: distances) {
            printDistanceOfCar(distance);
        }
        System.out.println();
    }
}
