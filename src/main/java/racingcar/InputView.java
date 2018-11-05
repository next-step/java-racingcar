package racingcar;

import java.util.Scanner;

public class InputView {

    private Car[] car;
    private int time;

    public InputView() { }

    public Car[] getCar() { return car; }
    public int getTime(){
        return time;
    }

    public void setCar(Car[] car) { this.car = car; }
    public void setTime(int time) {
        this.time = time;
    }

    public void inputSetting(){
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,))를 기준으로 구분");
        String[] names = sc.next().split(",");
        Car[] carArr = new Car[names.length];
        int i=0;
        for (String carName : names) {
            carArr[i++] = new Car(carName);
        }
        setCar(carArr);

        System.out.println("시도할 회수는 몇 회 인가요?");
        setTime(sc.nextInt());
    }

}
