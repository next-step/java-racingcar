import application.cli.GameMachine;
import domain.service.RacingCarGame;

public class MainApplication {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine(new RacingCarGame());
        gameMachine.start();
    }
}
