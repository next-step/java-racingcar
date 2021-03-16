package step3.view;

import step3.exception.CarRaceCheckInputException;

import java.util.Scanner;


public class InputView {

    private int carCount;

    private int racingCount;

    public void inputData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scan.nextInt();


        System.out.println("시도할 회수는 몇 회 인가요?");
        int racingCount = scan.nextInt();

        this.saveInputData(carCount, racingCount);

    }

    public void saveInputData(int carCount, int racingCount) {
        if(carCount < 1){
            throw new CarRaceCheckInputException("자동차 수가 유효하지 않습니다. 입력값 : %d".replace("%d",Integer.toString(carCount)));
        }

        if(racingCount < 1){
            throw new CarRaceCheckInputException("시도할 회수가 유효하지 않습니다. 입력값 : %d".replace("%d",Integer.toString(carCount)));
        }

        this.carCount = carCount;
        this.racingCount = racingCount;
    }


    public int getCarCount() {
        return carCount;
    }

    public int getRacingCount() {
        return racingCount;
    }
}
