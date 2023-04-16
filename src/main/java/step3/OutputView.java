package step3;

public class OutputView {

    public static void printCarPosition(Car[] cars) {
        for (Car car : cars) {
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    public static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
