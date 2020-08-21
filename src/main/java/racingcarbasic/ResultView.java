package racingcarbasic;


public class ResultView {
    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printResult(RacingCars racingCars) {
        racingCars.getCarList()
                .forEach(car -> {
                    int step = car.getStep();
                    System.out.println(car.getName()+" : "+new String(new char[step]).replace("\0", "-"));
                });
        System.out.println();
    }
}
