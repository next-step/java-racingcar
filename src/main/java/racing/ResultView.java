package racing;

public class ResultView {

    private ResultView() {
    }

    public static void status(Car car) {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < car.carDistance(); i++) {
            status.append("-");
        }

        System.out.println(car.carName() + ": " + status);
    }
}
