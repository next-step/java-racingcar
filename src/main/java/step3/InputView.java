package step3;

import java.util.Scanner;

public class InputView {
    private Integer numberOfCar;
    private Integer tryCount;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        this.numberOfCar = numberOfCar;
        this.tryCount = tryCount;
    }

    public Integer getNumberOfCar() {
        return numberOfCar;
    }

    public Integer getTryCount() {
        return tryCount;
    }


}
