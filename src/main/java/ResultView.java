import java.util.List;

public class ResultView {


    public void printResult(List<Car> cars, int numberOfAttempts) {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            for (int j = 0; j < cars.size(); j++) {
                int position = cars.get(j).getLocationRecord().get(i);
                for (int k = 0; k < position; k++) {
                    System.out.print("=");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
}
