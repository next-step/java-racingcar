package step2;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    int turn;
    Car[] cars;

    public ResultView(Racing racing) {
        turn = racing.turn;
        cars = racing.cars;
    }

    public void show() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        for (int game = 1; game <= turn; game++) {
            drawCars(game);
        }
    }

    private void drawCars(int turn) {
        for (Car car : cars) {
            int score = car.getScore(turn);
            draw(score);
        }
        System.out.println();
    }

    private void draw(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
