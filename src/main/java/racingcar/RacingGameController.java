package racingcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGameController {

    private final int LOWER_BOUND_MOVE = 4;

    private ArrayList<RacingCar> cars = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private int numberOfRound;


    public void getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");


        String input = sc.nextLine();

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] inputs = input.split(",");
        for (int i=0; i<inputs.length; i++){
            cars.add(new RacingCar(inputs[i]));
        }
    }

    public void getRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = sc.nextLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        numberOfRound = sc.nextInt();

    }

    public void findWinner() {

    }

    public int getRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(10);
    }

    public void playRound() {
        for(int i=0; i<cars.size(); i++) {
            moveEachCar(cars.get(i));
        }
    }

    public void start() {
        for(int i=0; i<numberOfRound; i++) {
            playRound();
        }
    }

    public void moveEachCar(RacingCar racingCar) {
        if(getRandomNumber() >= LOWER_BOUND_MOVE) {
            racingCar.movingForward();
        }
    }
}
