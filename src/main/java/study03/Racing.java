package study03;

/*
 *
 * Racing
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class Racing {

    private final int tryCount;
    private final CarFactory carFactory;

    public Racing(int carCount, int tryCount) {
        carFactory = new CarFactory(carCount);
        this.tryCount = tryCount;
    }

    public void run() {
        System.out.println("실행결과");
        for (int i = 1; i <= tryCount; i++) {
            carFactory.moveCarsPerTryCount(i);
        }
    }
}
