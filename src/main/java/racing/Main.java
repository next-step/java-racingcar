package racing;

import racing.domain.*;
import racing.view.Input;
import racing.view.View;

public class Main {


    public static void main(String[] args) {
        Input input = new Input();
        View view = new View();
        NumberProvider numberProvider = new RandomNumberProvider();
        MovableStrategy movableStrategy = new RandomNumMovableStrategy(numberProvider);

        Application application = new Application(input, view, movableStrategy);
        application.run();
    }
}
