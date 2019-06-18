public class RacingGame {
    private int timeOfGame; // 자동차 경주 횟수
    private int numberOfCar;    // 자동차 대수
    private int[] carPositions; // 자동차 위치 정보
    private String[] carStatus; // 자동차 경주 결과 정보

    public int getTime() {
        return timeOfGame;
    }

    public void setTime(int time) {
        this.timeOfGame = time;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        InputView inputView = new InputView(); // 사용자 입력을 위한 객체 생성

        inputView.userInput(racingGame);  //사용자 입력 실행
    }
}
