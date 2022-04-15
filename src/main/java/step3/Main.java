package step3;

public class Main {


    public static void main(String[] args) {
        Input input = new Input();
        View view = new View();
        MovableStrategy movableStrategy = new RandomNumMovableStrategy();

        Application application = new Application(input, view, movableStrategy);
        application.run();
    }
}
