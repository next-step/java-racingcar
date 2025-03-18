public final class ResultView {

    public static void printWinners(String winners) {
        System.out.print(winners + "가 최종 우승했습니다.");
    }

    private ResultView() {}

    public static void printResult(final Car[] cars) {
        for (Car car : cars) {
            printCarPosition(car.getName(), car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    private static void printCarPosition(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
    }
}
