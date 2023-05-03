import java.util.List;

public class ResultView {

    public void show(Cars cars) {
        List<Car> results = cars.showCars();

        for (Car result : results) {
            print(result.getPosition());
        }
    }

    private void print(int position) {
        for (int i = 0; i < position + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}