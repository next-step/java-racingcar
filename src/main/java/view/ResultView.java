package view;

import CarRacing.CarRacing;

public class ResultView {

    private int carCount;
    private int tryCount;

    public ResultView(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        if (tryCount < 0) {
            throw new IllegalArgumentException("레이스횟수는 음수는 허용하지 않습니다.");
        }
    }


    public void startRacing() {
        System.out.println("dfd" + tryCount);
        CarRacing carRacing = new CarRacing(5);

        for (int i = 0; i < tryCount; i++) {
            carRacing.moveCarList();
            carRacing.getCarList().forEach(s -> System.out.println(new String(new char[s.getCarPosition()]).replace("\0", "-")));
        }
    }
}
