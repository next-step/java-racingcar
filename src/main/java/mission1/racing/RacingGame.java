package mission1.racing;

public class RacingGame {
    private int time;
    private int carNumber;

    private Movement movement;
    private RacingGameView view = new RacingGameView();

    public void startGame() {
        setGame();

        for(int i = 0; i < time; i++) {
            movement.move();
        }
    }

    private void setGame() {
        time = view.inputView("시도할 회수는 몇 회 인가요?");
        carNumber = view.inputView("자동차 대수는 몇 대 인가요?");

        movement = new Movement(carNumber);
    }
}
