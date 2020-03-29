package step4.racing.ui;

import step4.racing.domain.Car;
import step4.racing.domain.RacingGame;
import step4.racing.domain.RacingInfo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResultView {
    private RacingGame racingGame;
    private RacingInfo racingInfo;
    private List<Car> cars;
    private List<Car> winnerCars = new ArrayList<>();

    private static final String POSITION_CHAR = "-";
    private static final String SEPERATOR = " : ";
    private static final String NAME_SEPERATOR = ",";

    public ResultView(RacingGame racingGame, RacingInfo racingInfo) {
        this.racingGame = racingGame;
        this.racingInfo = racingInfo;
        this.cars = racingGame.getCars();
    }

    public void view() {
        int count = racingInfo.getCount();

        for (int i = 0; i < count; ++i) {
            viewResult(racingGame.move());
        }

        printWinner();
    }

    public void viewResult(List<Car> cars) {
        for (Car car : cars) {
            printlnString(printPosition(car));
        }
        printlnString("###############################################");
    }

    public String printPosition(Car car) {
        int positionOfCar = car.getPosiotion();
        StringBuffer sb = new StringBuffer();
        sb.append(car.getName() + SEPERATOR);
        for (int i = 0; i < positionOfCar; i++) {
            sb.append(POSITION_CHAR);
        }

        return sb.toString();
    }

    private void printWinner() {
        printString(printWinners(getWinner(cars, getMaxPosition(cars), winnerCars)));
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream().max(Comparator.comparing(Car -> Car.getPosiotion())).get().getPosiotion();
    }

    public List<Car> getWinner(List<Car> cars, int maxPosition, List<Car> winnerCars) {
        StringBuffer sb = new StringBuffer();
        for (Car car : cars) {
            putWinner(car, maxPosition, winnerCars);
        }

        return winnerCars;
    }

    private void putWinner(Car car, int maxPosition, List<Car> winnerCars) {
        if (car.getPosiotion() == maxPosition) {
            winnerCars.add(car);
        }
    }

    public String printWinners(List<Car> winnerCars) {
        StringBuffer sb = new StringBuffer();
        sb.append("최종 우승자는 ");
        sb.append(winnerCars.get(0).getName());

        for (int i = 1; i < winnerCars.size(); i++) {
            sb.append(NAME_SEPERATOR);
            sb.append(winnerCars.get(i).getName());
        }
        sb.append(" 입니다.");

        return sb.toString();
    }

    public void printString(String inputString) {
        System.out.print(inputString);
    }

    public void printlnString(String inputString) {
        System.out.println(inputString);
    }
}
