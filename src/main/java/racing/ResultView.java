package racing;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(Cars cars) {
        cars.dashOfCarPositions().forEach(System.out::println);
        System.out.println();
    }
}
