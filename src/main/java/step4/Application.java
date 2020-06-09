package step4;

public class Application {

    public static void main(String[] args) {
        Cars cars = InputView.getCars();
        int rounds = InputView.getRounds();
        Race race = new Race(cars, rounds);
        race.start();
    }
}
