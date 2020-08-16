package racingcarbasic;


import java.util.ArrayList;

public class ResultView {
    public ResultView() {
        System.out.println("실행 결과");
    }

    public void ResultPrint(ArrayList<RacingCar> carList) {
        for (RacingCar car : carList) {
            int step = car.step;
            System.out.println(new String(new char[step]).replace("\0", "-"));
        }
        System.out.println();
    }
}
