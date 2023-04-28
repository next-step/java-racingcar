package racing;

import racing.race.Race;
import racing.ui.InputView;
import racing.ui.DisplayView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        DisplayView displayView = new DisplayView();

        Race race = new Race(inputView, displayView);
        race.start();
    }
}
