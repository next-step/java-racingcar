package study.step3;

public class ResultView {

    public void printStateBoard(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.printPosition());
        }
        System.out.println();
    }

    public void printWinner(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }


}
