package step3.view;

import step3.exception.CarRaceCheckInputException;
import step3.util.InputValidator;

import java.util.Scanner;


public class InputView {

    private int carCount;

    private int racingCount;

    public InputView(){
    }
    public InputView(int carCount, int racingCount) {
        this.carCount = carCount;
        this.racingCount = racingCount;
    }

    public void inputData() {

        Scanner scan = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scan.nextInt();


        System.out.println("시도할 회수는 몇 회 인가요?");
        int racingCount = scan.nextInt();

        this.saveInputData(carCount, racingCount);

    }

    public void saveInputData(int carCount, int racingCount) {
        InputValidator.validate(carCount, racingCount);

        this.carCount = carCount;
        this.racingCount = racingCount;
    }


    public int getCarCount() {
        return carCount;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public boolean validateCar(){
        return this.carCount < 1 ;
    }


    public boolean validateRacing(){
        return this.racingCount < 1 ;
    }

    public boolean isRacing(){
        return this.racingCount > 0;
    }

    public void reduceRacing(){
        this.racingCount--;
    }
}
