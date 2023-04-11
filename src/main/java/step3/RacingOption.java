package step3;

public class RacingOption {

    private final int numberOfCars;
    private final int numberOfRounds;

    public RacingOption(int numberOfCars, int numberOfRounds) {
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
        validCheck();
    }

    private void validCheck() {
        if (numberOfCars < 1) {
            ResultView.printError("레이싱 게임을 시작하기 위해서는 차가 한 대 이상 필요합니다.");
            throw new IllegalArgumentException();
        }
        if (numberOfRounds < 1) {
            ResultView.printError("레이싱 게임을 위해서는 라운드 수가 1회 이상 필요합니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
