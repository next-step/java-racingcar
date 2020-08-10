package carracing.view;

import java.util.Scanner;

public class InputView {

    private int carCount = 0;
    private int tryCount = 0;

    public InputView() {
        initView();
    }

    private void initView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carCount = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.tryCount = sc.nextInt();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
