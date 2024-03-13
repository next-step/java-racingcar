package step3;

import java.util.Random;
import java.util.Scanner;

public class Race {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요? ");
        int racingCarCount = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요? ");
        int trials = scan.nextInt();

        Car[] carArray = generateCarArray(racingCarCount);

        // 게임 진행
        for (int turn = 0; turn < trials; turn++) {
            startMoving(carArray);
            System.out.println();
        }
    }

    public static Car[] generateCarArray(int carCount){
        Car[] carArray = new Car[carCount];
        for (int index = 0; index < carCount; index++) {
            carArray[index] = new Car();
        }
        return carArray;
    }

    public static void startMoving(Car[] carArray){
        for (int i = 0; i < carArray.length; i++) {
            System.out.println(carArray[i].getPosition());
            int chance = getRandomSingleDigitNumber();
            carArray[i].move(chance);
        }
    }

    public static int getRandomSingleDigitNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

}

class Car{

    private static final int MIN_AVAILABLE_CHANCE = 4;

    private String position = "-";

    public Car() {
    }

    public void move(int chance) {
        if (chance >= MIN_AVAILABLE_CHANCE){
            this.position += "-";
        }
    }
    public String getPosition() {
        return position;
    }
}
