package study.step3;

public class ResultView {

    public void printStateBoard(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + printCarPosition(car));
        }
        System.out.println();
    }

    String printCarPosition(Car car) {
        return "-".repeat(car.getPosition());
    }

    public void printWinner(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }


}
