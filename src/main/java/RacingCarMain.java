public class RacingCarMain {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        String carNames = racingCar.inputCarNames();
        int roundNumber = racingCar.inputRoundNumber();
        racingCar.makeResult(carNames, roundNumber);
    }
}
