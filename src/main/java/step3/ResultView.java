package step3;

public class ResultView {

    public ResultView() {
        System.out.println(" ");
    }

    private final String GO = "-";

    public void result(Car[] cars) {

        for (int i = 0; i < cars.length; i++) {
            view(cars[i].movement);
        }
    }

    private void view(int count) {
        for(int i = 0; i < count; i ++) {
            System.out.print(GO);
        }
        System.out.println("");
    }
}
