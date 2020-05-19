package racing;

import java.util.List;

public class ResultView {
    private String message;

    public ResultView(String message) {
        this.message = message;
        init();
    }

    private void init() {
        System.out.println(message);
    }

    public void print(List<Car> carList) {
        for (Car car : carList) {
            drawCarPosition(car.showMyPosition());
        }

        System.out.println();
    }

    private void drawCarPosition(int position) {
        StringBuilder paper = new StringBuilder();

        for (int i = 0; i < position; i++) {
            paper.append("-");
        }

        System.out.println(paper.toString());
    }
}
