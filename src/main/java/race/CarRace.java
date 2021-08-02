package race;

public class CarRace {

    private int carCount;

    private int gameCount;
    
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

    public void initGame() {
        setGameProfile();
    }

    protected void setGameProfile() {
        carCount = setCarCount();
        gameCount = setGameCount();
    }

    protected int setCarCount() {
        printOut(messageCarCount);
       return InputOutput.inputOutput();
    } 

    protected int setGameCount() {
        printOut(messageGameCount);
        return InputOutput.inputOutput();
    }
    
    private void printOut(String message) {
        System.out.println(message);   
    }
}
