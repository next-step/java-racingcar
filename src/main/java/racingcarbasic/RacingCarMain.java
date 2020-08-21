package racingcarbasic;

public class RacingCarMain {

    public static void main(String[] args) {
        /* 자동차 이름 리스트와 이동 횟수 받기 */
        InputView inputView = new InputView();
        String[] carNameList = inputView.getCarNameList();
        int moveCount = inputView.getMoveCount();

        /* 자동차 이름 검사 */
        ValidationName validationName = new ValidationName();
        validationName.validateName(carNameList);

        /* RacingCar 인스턴스 생성 */
        RacingCars racingCars = RacingCars.of(carNameList, new StraightMove());

        ResultView resultView = new ResultView();
        for (int i = 0; i < moveCount; i++) {
            racingCars.moveCars();
            resultView.ResultPrint(racingCars);
        }

    }
}
