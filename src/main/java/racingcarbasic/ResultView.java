package racingcarbasic;


public class ResultView {
    public ResultView() {
        System.out.println("실행 결과");
    }

    public void ResultPrint(RacingCars racingCars) {
        racingCars.getCarList()
                .forEach(car -> {
                    int step = car.getStep();
                    System.out.println(new String(new char[step]).replace("\0", "-"));
                });
        System.out.println();
    }
}
