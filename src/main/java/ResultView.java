import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    private ResultView() {
        // private 생성자로 인스턴스화 방지
    }

    public static void presentStartMessage() {
        System.out.println("실행 결과");
    }

    public static void presentCars(List<CarStatus> cars) {
        for (CarStatus car : cars) {
            String positionIndicator = "-".repeat(car.getPosition() + 1);
            String output = String.format("%s : %s", car.getName(), positionIndicator);
            System.out.println(output);
        }
        System.out.println();
    }

    public static void presentWinners(List<CarStatus> winners) {
        StringJoiner joiner = new StringJoiner(", ");
        for (CarStatus winner : winners) {
            joiner.add(winner.getName());
        }
        System.out.println(joiner.toString() + "가 최종 우승했습니다.");
    }
}
