package racing;

import java.util.*;

public class Racing {


    static final int NAME_LENGTH = 5;
    static final int MOVE_NUMBER = 4;
    static final int MAX_RANDOM = 10;
    static final int WINNER_NUMBER = 0;
    static Random random = new Random();
    static RacingView racingView = new RacingView();

    public void racing() {
        String str = racingView.inputRacingCar();
        int num = racingView.inputNum();
        List<Car> cars = getCars(getCarName(str));
        racingView.resultExecutionResult();
        for (int i = 0; i < num; i++) {
            getMovingRange(cars);
        }
        List<String> winner = getWinners(cars);

    }

    private List<Car> getCars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }

    public String[] getCarName(String str) {
        String[] carNames = str.split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > NAME_LENGTH) throw new IllegalArgumentException("이름은 5자 이내로 .");
        }
        return carNames;
    }

    private void getMovingRange(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            getRandomMove(random.nextInt(MAX_RANDOM), cars.get(i));
            racingView.resultOneExecutionResult(cars);
        }
    }

    public Car getRandomMove(int random, Car car) {
        if (random > MOVE_NUMBER) car.moved();
        return car;
    }

    public List<String> getWinners(List<Car> cars) {
        Collections.sort(cars);
        List<String> winner = new ArrayList<>();
        winner.add(cars.get(WINNER_NUMBER).getName());
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getMovingRange() == cars.get(WINNER_NUMBER).getMovingRange()) {
                winner.add(cars.get(i).getName());
            }
        }
        racingView.resultWinner(winner);
        return winner;
    }
}
