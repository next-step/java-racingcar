public class ResultView {
    private static final char dash = '-';

    public static void printCarLocation(Car car) {
        for (int i = 0; i < car.getLocation(); i++)
            System.out.print(dash);
        System.out.println();
    }
}
