package car_racing;

public class OutputView {

    private static final String OUT_MESSAGE_CAR_RACING_RESULT = "실행 결과\n";

    public void showCarRacingGameOutput(CarRacingResult carRacingResult) {
        System.out.println(OUT_MESSAGE_CAR_RACING_RESULT);
        System.out.println(carRacingResult.show());
    }
}
