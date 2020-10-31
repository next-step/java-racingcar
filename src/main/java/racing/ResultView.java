package racing;

public class ResultView {

    public void viewMessage() {
        System.out.println("실행 결과");
    }

    public void viewRoundResult(Entry entry) {
        for (Car car : entry.getCars()) {
            System.out.println(car.getDisplacement());
        }

        System.out.println();
    }
}
