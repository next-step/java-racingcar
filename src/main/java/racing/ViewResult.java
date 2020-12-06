package racing;

public class ViewResult {
    private static final int ZERO = 0;

    public void view(Cars cars) {
        for (Car car : cars.getCars()) {
            StringBuilder results = createResultMessage(car);
            System.out.println(results);
        }
        System.out.println();
    }

    private StringBuilder createResultMessage(Car car) {
        StringBuilder results = new StringBuilder();
        if (car.getMoveCount() == ZERO) {
            System.out.println("");
        }

        for (int i = 0; i < car.getMoveCount(); i++) {
            results.append("-");
        }
        return results;
    }

    public void showFirstLine() {
        System.out.println("실행 결과");
    }
}
