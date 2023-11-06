import racing.Car;
import racing.RacingGame;
import racing.RacingGameEngine;
import ui.RacingGameRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        RacingGameEngine gameEngine = RacingGameEngine.create();
        gameEngine.play();
    }
}
