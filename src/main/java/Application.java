import racingcar.Cars;
import racingcar.GuideView;

public class Application {

    public static void main(String[] args) {

        GuideView guideView = new GuideView();
        int numberOfCars = guideView.inputNumberOfCars();
        int numberOfAttempts = guideView.inputNumberOfAttempts();
        guideView.printResultMessage();

        Cars cars = new Cars(numberOfCars);
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.attempt();
            System.out.println(cars.toString());
        }
    }
}
