package carrace;

public class Main {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        inputView.ask();

        Cars cars = new Cars(inputView.getPlayers());
        final CarRace carRace = new CarRace(cars, inputView.getTotalLabs(), new RandomMovable());
        carRace.start();

        ResultView.print(carRace);
    }
}
