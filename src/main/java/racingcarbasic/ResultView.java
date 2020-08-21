package racingcarbasic;


import java.util.List;

public class ResultView {
    public ResultView() {
        System.out.println("실행 결과");
    }

    public void ResultPrint(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            int step = car.getStep();
            System.out.println(new String(new char[step]).replace("\0", "-"));
        }
        System.out.println();
    }
}
