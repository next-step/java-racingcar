package step3;

public class ResultView {

    private final String GO = "-";

    public ResultView() {
        System.out.println(" ");
    }

    public void result(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            view(cars[i].point);
        }
    }

    private void view(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(GO);
        }
        System.out.println("");
    }
}
