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

        cars = new Car[carCount];
        gameResults = new String[gameCount];

        String stringTmp = "";
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
            stringTmp += (cars[i].getStatus()+"\n");
        }
        gameResults[0] = stringTmp;
        for(int i=1;i<gameCount;i++){
            stringTmp = "";
            for (int j = 0; j < carCount; j++) {
                Random r = new Random();
                int randomNum = r.nextInt(NUMBERBOUND);
                if(randomNum >= MINMOVENUMBER){
                    cars[j].move();
                }
                stringTmp += (cars[j].getStatus()+"\n");
            }
            gameResults[i] = stringTmp;
        }
    }

}
