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
        //input관련 UI로직을 InputView클래스에 깔끔이 추출하는 방법이 떠오르지 않는다.
        //int carNum, tryNum 값을 묶는 vo를 설계해야할까? => vo클래스에 getter/setter, 생성자함수도 만들어야 될듯...

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carNum = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.tryNum = sc.nextInt();
    }

    public void run(){

        System.out.println("\n실행 결과");

        for (int tryCnt = 0; tryCnt < tryNum; tryCnt++) {

            moveAllCars();

            ResultView.showState(carNum, cars);
        }

    }

    private void moveAllCars() {
        for (int i = 0; i < carNum; i++) {
            checkMoveCondition(i);
        }
    }

    private void checkMoveCondition(int i) {
        if(getRandomNum() >= 4){
            cars[i]++;
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
