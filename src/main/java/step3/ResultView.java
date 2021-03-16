package step3;

public class ResultView {

    public static void result(Car car) {
        StringBuilder catResult = new StringBuilder();
        for (int i = 0; i < car.getGoDistance(); ++i) {
            catResult.append("-");
        }

        System.out.println(catResult.toString());
    }
}
