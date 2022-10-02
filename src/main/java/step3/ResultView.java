package step3;

import java.util.List;

public class ResultView {

    private static final String HYPHEN = "-";

    public void output(List<Car> carList) {
        carList.stream()
                .mapToInt(Car::getPosition)
                .forEach(this::print);
        System.out.println();
    }

    private void print(int position) {
        String print = "";
        for (int i = 0; i < position; i++) {
            print += HYPHEN;
        }
        System.out.println(print);
    }
}
