package step4;

public class ResultView {

    private static final char FORWARDING = '-';
    private Car car;

    public ResultView(Car car) {
        this.car = car;
    }

    public void printEachCar() {
        String result = "";
        for (int i = 0; i < car.getAdvance(); i++) {
            result += FORWARDING;
        }
        System.out.println(car.getName() + " : " + result);
    }

    public void printFinalWinner() {
        String names = "";
        System.out.println(names + "가 최종 우승했습니다.");
    }


}
