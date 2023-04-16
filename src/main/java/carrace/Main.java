package carrace;

public class Main {

    public static void main(String[] args) {
        final String participants = InputView.HOW_MANY_CARS.getAnswer();
        final String numberOfLabs = InputView.HOW_MANY_LABS.getAnswer();

        Cars cars = new Cars(participants);
        final CarRace carRace = new CarRace(cars, numberOfLabs, new RandomMovable());
        carRace.start();

        ResultView.print(carRace);
    }
}
