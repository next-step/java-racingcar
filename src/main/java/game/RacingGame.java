package game;

import java.io.Console;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private Integer round;
    private final static String INPUT_CAR_GUIDE = "자동차 대수는 몇 대 인가요?";
    private final static String INPUT_ROUND_GUIDE = "시도할 회수는 몇 회 인가요?";

    public static RacingGame start(){
        RacingGame racingGame = new RacingGame();
        racingGame.inputNumberOfCar();
        racingGame.inputNumberOfRound();
        return racingGame;
    }

    public void inputNumberOfCar() {
        System.out.println(INPUT_CAR_GUIDE);
        makeCar(inputPositiveNumber());
    }

    private void makeCar(int inputPositiveNumber) {
        for (int i = 0; i < inputPositiveNumber; i++) {
            cars.add(new Car());
        }
    }

    public void inputNumberOfRound() {
        System.out.println(INPUT_ROUND_GUIDE);
        this.round = inputPositiveNumber();
    }

    private static int inputPositiveNumber() {
        try {
            Scanner sc = new Scanner(System.in);
            int result = sc.nextInt();
            checkPositiveNumber(result);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void checkPositiveNumber(int result) {
        if (result < 0) {
            throw new RuntimeException();
        }
    }

    public int cars() {
        return cars.size();
    }

    public int round() {
        return round;
    }
}
