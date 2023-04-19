package RacingCar;

import java.util.Random;
import java.util.Scanner;

public class RacingCarRunner {
    public int getUserInput() {
        Scanner s = new Scanner(System.in);
        return Integer.parseInt(s.nextLine());
    }

    public int runOrStop(int randomNumber) {
        int currentPosition = 0;

        if (isRunnable(randomNumber)) {
            currentPosition++;
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

    public void printRacingCarResult() {
        for (int i = 0; i < runOrStop(getRandomNumber()); i++) {
            System.out.println("-");
        }
    }
}
