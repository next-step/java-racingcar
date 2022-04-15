package step3;

public class Main {


    public static void main(String[] args) {
        Input input = new Input();
        View view = new View();

        Application application = new Application(input, view);
        application.run();
    }
}
