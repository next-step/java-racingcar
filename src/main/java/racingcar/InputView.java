package racingcar;

import java.util.Scanner;

public class InputView {

    private int carCount;
    private int time;

    public InputView() { }

    public int getCarCount() {
        return carCount;
    }
    public int getTime(){
        return time;
    }

    public void setCarCount(int carCount){
        this.carCount = carCount;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public void inputSetting(){
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        setCarCount(sc.nextInt());
        System.out.println("시도할 회수는 몇 회 인가요?");
        setTime(sc.nextInt());
    }

}
