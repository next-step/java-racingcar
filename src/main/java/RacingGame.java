
public class RacingGame {

    public int toInteger(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("정수만 입력이 가능합니다.");
        }
    }

    public void start() {
        InputView inputView = new InputView();
        String value = inputView.inputIntArgument("자동차 대수는 몇 대 인가요?");
        int numberOfCars =  toInteger(value);

        value = inputView.inputIntArgument("시도할 회수는 몇 회 인가요?");
        int numberOfAttempts = toInteger(value);

        Cars cars = CarFactory.generateCars(numberOfCars);
        cars.setMoveStrategy(new ConditionStrategy());

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.advanceCars();
            ResultView.showRaceRound(cars.getCarRecords());
        }
    }
}
