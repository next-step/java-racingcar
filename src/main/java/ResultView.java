public final class ResultView {

    private ResultView() {}

    public static void printResult(final Car[] cars) {
        for (Car car : cars) {
            printCarPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    private static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
    }
}
