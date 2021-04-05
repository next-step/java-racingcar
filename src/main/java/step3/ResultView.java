package step3;

public class ResultView {

    public ResultView() {
        System.out.println(" ");
    }

    public final String GO = "-";

    public void result(Car[] cars) {

        for (int i = 0; i < cars.length; i++) {
            view(cars[i].movement);
        }
    }

    public void view(int count) {
        for(int i = 0; i < count; i ++) {
            System.out.print(GO);
        }
        System.out.println("");
    }
}
