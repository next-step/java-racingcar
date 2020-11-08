package racingcar;

public class OutputView {
    private final String RESULT_MENTION = "실행결과";
    private final String PRESENT_MOVE = "-";

    public void resultMention() {
        System.out.println(RESULT_MENTION);
    }

    public void displayCarList(CarList carList) {
        for(Car car : carList.getCarList()) {
            displayCar(car);
        }
        System.out.println();
    }

    private void displayCar(Car car) {
        System.out.print(car.getName() + " : ");
        for(int position = 0; position < car.getCurrentPosition(); position++) {
            System.out.print(PRESENT_MOVE);
        }
        System.out.println();
    }
}
