package racing;

public class ViewResult {
    public static final String DELIMITER_SEMICOLON = " : ";
    private static final String MOVE_BAR = "-";

    public void view(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + DELIMITER_SEMICOLON);
            StringBuilder results = createResultMessage(car);
            System.out.println(results);
        }
        System.out.println();
    }

    private StringBuilder createResultMessage(Car car) {
        StringBuilder results = new StringBuilder("");
        for (int i = 0; i < car.getMoveCount(); i++) {
            results.append(MOVE_BAR);
        }
        return results;
    }

    public void showFirstLine() {
        System.out.println("실행 결과");
    }
}
