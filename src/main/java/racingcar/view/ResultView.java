package racingcar.view;

public class ResultView {
    private static String DISTANCE = "-";

    public static void printNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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
