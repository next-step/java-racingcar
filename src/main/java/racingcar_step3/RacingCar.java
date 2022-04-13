package racingcar_step3;

import lombok.Getter;

import java.util.Random;
import java.util.Scanner;

@Getter
public class RacingCar {

    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    private int[] cars = new int[100];

    private int carNum, tryNum;

    public RacingCar(int carNum, int tryNum) {
        this.carNum = carNum;
        this.tryNum = tryNum;
    }

    public RacingCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carNum = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.tryNum = sc.nextInt();
    }

    public void run(){

        System.out.println("\n실행 결과");

        for (int tryCnt = 0; tryCnt < tryNum; tryCnt++) {

            move();

            showState();
        }

    }

    private void showState() {
        for (int i = 0; i < carNum; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cars[i]; j++) {
                sb.append('-');
            }
            System.out.println(sb.toString());
        }
        System.out.println("");
    }

    private void move() {
        for (int i = 0; i < carNum; i++) {
            if(getRandomNum() >= 4){
                cars[i]++;
            }
        }
    }

    public int getRandomNum() {
        return random.nextInt(10);
    }

    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        racingCar.run();
    }
}
