package Car;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    private Car[] cars;
    private int carCount;
    private int gameCount;
    private String[] gameResults;

    private final int NUMBERBOUND = 10;
    private final int MINMOVENUMBER = 4;

    public void gameStart() {
        getInput();
        setCarsResult();
        for (int i = 1; i < gameCount; i++) {
            doGame();
            setGameResults(i);
        }
        printGameResult();
    }

    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("자동차 대수는 몇 대 인가요?");
            carCount = scanner.nextInt();
            System.out.println("시도할 회수는 몇 회 인가요?");
            gameCount = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자 값을 입력해주세요.");
        }
        if (carCount <= 0 || gameCount <= 0) {
            throw new IllegalArgumentException("0보다 큰 값을 입력해주세요.");
        }
    }

    private void setCarsResult() {
        cars = new Car[carCount];
        gameResults = new String[gameCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
        setGameResults(0);
    }

    private void doGame() {
        for (int j = 0; j < carCount; j++) {
            int randomNumber = getRandomNumber();
            if (isMove(randomNumber)) {
                cars[j].move();
            }
        }
    }

    private int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(NUMBERBOUND);
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= MINMOVENUMBER;
    }

    private void setGameResults(int index) {
        gameResults[index] = "";
        for (int i = 0; i < carCount; i++) {
            gameResults[index] += (cars[i].getStatus() + "\n");
        }
    }

    private void printGameResult() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            System.out.println(gameResults[i]);
        }
    }
}
