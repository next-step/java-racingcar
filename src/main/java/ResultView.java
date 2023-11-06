public class ResultView {

    public static void print(Car[] cars) {
        for (Car car : cars) {
            printLine(car);
        }
        System.out.println();
    }

    private static void printLine(Car car) {
        for (int i = 0; i < car.forwardCount; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

}
