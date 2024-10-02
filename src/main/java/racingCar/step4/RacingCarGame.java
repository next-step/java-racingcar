package racingCar.step4;

public class RacingCarGame {
    public void gameStart(){
        String carNames = InputView.getCarNamesInputFromUser();
        int racingCount = InputView.getRacingCountInputFromUser();

        System.out.format("차 이름 : %s", carNames);
        System.out.format("레이싱 횟수 : %d", racingCount);

    }
}
