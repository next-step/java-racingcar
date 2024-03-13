package racing;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Input input = new Input();

        game.createAttendedCars(input.CarNumber());
        game.playGame(input.AttemptsNumber());

        input.close();
    }
}
