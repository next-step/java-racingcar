public class ResultView {
    private final char dash = '-';

    public void printCarLocation(Car car) {
        for (int i=0; i<car.getLocation(); i++)
            System.out.print(dash);
        System.out.println();
    }
}
