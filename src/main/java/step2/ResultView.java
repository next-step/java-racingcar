package step2;

public class ResultView {
    private static final String POSITION = "-";

    public static void printStartMessage(String[] carNames) {
        System.out.println("실행 결과");
        for (String carName : carNames) {
            printCarInfo(carName);
        }
        newLine();
    }

    public static void print(Car[] cars) {
        for (Car car : cars) {
            iteratePrint(car);
            newLine();
        }
        newLine();
    }

    private static void printCarInfo(String carName) {
        System.out.println(carName + " : " + "-");
    }

    private static void iteratePrint(Car car) {
        int movedPosition = car.getPosition();
        printCarName(car.getName());

        for (int i = 0; i < movedPosition; i++) {
            System.out.print(POSITION);
        }
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private static void newLine() {
        System.out.println();
    }
}
