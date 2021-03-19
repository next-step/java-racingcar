package ch01.racinggame.view;

import ch01.racinggame.Domain.InputData;

import java.util.Scanner;

public class InputView {
<<<<<<< HEAD

    public InputData getInputData() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner sc = new Scanner(System.in);
        int carCount = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = sc.nextInt();
        return new InputData(carCount,attemptCount);
    }
=======
    int carCount = 0;
    int attemptCount = 0;
    String[] progressArr;

    public InputView(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner sc = new Scanner(System.in);
        this.carCount = sc.nextInt();

        progressArr = new String[carCount];

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.attemptCount = sc.nextInt();
    }


    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public String[] getProgressArr() {
        return progressArr;
    }

    public void setProgressArr(String[] progressArr) {
        this.progressArr = progressArr;
    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }




>>>>>>> 폴더명 정리
}
