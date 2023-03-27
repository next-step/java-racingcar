package racingcar.domain;
import java.util.*;

public class RacingCar {

    String gameWinner;

    public RacingCar(){
    }

    public RacingCar(List<Car> cars, int gameCount){
        startGame(cars, gameCount);
        gameWinner = judgeWinner(cars);
    }

    public String getGameWinner(){
        return gameWinner;
    }

    public void startGame(List<Car> cars, int gameCount){
        for(int i=0; i < gameCount; i++) {
            for (Car car : cars) {
                car.judgeMoving(getRandomValue());
            }
        }
    }

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static String judgeWinner(List<Car> cars){
        List<String> winner = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);

        for (Car car : cars) {
            if (car.move == maxPosition) {
                winner.add(car.name);
            }
        }
        return winner.toString();
    }

    public static int getMaxPosition(List<Car> cars){
        return cars.stream()
                .mapToInt(x -> x.getMove())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}