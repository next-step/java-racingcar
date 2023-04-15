package step3;

public class RacingOption {

    private static final NumberGenerator DEFAULT_NUMBER_GENERATOR = RandomNumberGenerator.of(9);

    private final int numberOfCars;
    private final int numberOfRounds;
    private final NumberGenerator numberGenerator;

    private RacingOption(int numberOfCars, int numberOfRounds, NumberGenerator numberGenerator) {
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
        this.numberGenerator = numberGenerator;
        validCheck();
    }

    public static RacingOption from(UserInput userInput) {
        return new RacingOption(userInput.getNumberOfCars(), userInput.getNumberOfRounds(), DEFAULT_NUMBER_GENERATOR);
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

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }
}
