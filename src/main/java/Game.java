import java.util.InputMismatchException;
import java.util.List;

public class Game {
    private View view = new View();
    private Input input = new Input();
    private RandomMaker randomMaker = new RandomMaker();

    public void playGame() {
        try {
            view.requestCarCount();
            int countCar = input.inputData();

            view.requestTryCount();
            int countTry = input.inputData();

            playRound(countCar, countTry);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void playRound(int countCar, int countTry) {
        Cars cars = new Cars();

        List<Car> carsList = cars.makeCars(countCar);
        view.printResult();

        for (int i = 0; i < countTry; i++) {
            playMove(carsList);
        }
    }

    private void playMove(List<Car> carsList) {
        for (int i = 0; i < carsList.size(); i++) {
            carsList.get(i).moveOnCondition(randomMaker.generateRandom());
            view.printCarMoving(resultStr(carsList.get(i)));
        }
        view.printSeperateCar();
    }

    public String resultStr(Car car) {
        String result = "";
        for (int i = 0; i < car.getPosition(); i++) {
            result += view.printMovingPattern();
        }
        return result;
    }
}