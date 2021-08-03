package race;

public class CarRace {

    private int carCount;

    private int gameCount;

    private String[] carDistance;

    private final String messageCarCount = "자동차 대수는 몇 대 인가요?";

    private final String messageGameCount = "시도할 회수는 몇 회 인가요?";

    public CarRace() {

    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        carRace.initGame();
    }

    public void initGame() {
        setGameProfile();
        playGame();
    }


    protected void setGameProfile() {
        carCount = setCarCount();
        gameCount = setGameCount();
        setCarDistance();
    }

    protected int setCarCount() {
        printOut(messageCarCount);
       return InputView.inputOutput();
    }

    protected int setGameCount() {
        printOut(messageGameCount);
        return InputView.inputOutput();
    }

    protected void setCarDistance() {
        carDistance = new String[carCount];
        for (int i = 0; i < carCount; i++) {
            carDistance[i] = "";
        }
    }


    private void printOut(String message) {
        System.out.println(message);
    }

    private void saveCarMovement() {

    }

    private void playGame() {
        while(gameCount-- > 0) {
            int tempCarCount = 0;
            loopCarCount();
            ResultView.printResult(carDistance);
        }
    }

    private void loopCarCount() {
        int tempCarCount = 0;
        while (tempCarCount < carCount) {
            checkRandomNum(tempCarCount);
            tempCarCount++;
        }
    }

    private void checkRandomNum(int tempCarCount) {
        if (RandomNum.getRandomNum() > 4)
            carDistance[tempCarCount] += "-";
    }

}
