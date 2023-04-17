package RacingCar;

import java.util.Random;
import java.util.Scanner;

public class RacingCarRunner {
    public int getUserInput() {
        Scanner s = new Scanner(System.in);
        return Integer.parseInt(s.nextLine());
    }

    public int run() {
        Car car = new Car();

        int currentPosition = car.getCurrentPosition();

        if (isRunnable(getRandomNumber())) {
            currentPosition += 1;
            car.setCurrentPosition(currentPosition);
        }

        return currentPosition;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isRunnable(int num) {
        return (num >= 4);
    }

    public static void main(String[] args) {
        RacingCarRunner rcr = new RacingCarRunner();

        System.out.println("자동차 대수는 몇 대 인가요?");
        System.out.println(rcr.getUserInput());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        System.out.println(rcr.getUserInput());
    }
}
