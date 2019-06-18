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

    // 자동차 경주의 최초 설정 세팅 함수
    public void gameInitialSet(int numberOfCar) {
        carPositions = new int[numberOfCar];
        carStatus = new String[numberOfCar];

        if (numberOfCar <= 1) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 레이싱 게임을 위해서 최소한 1보다 큰 숫자로 다시 입력해주세요.");
        }

        for (int i = 0; i < numberOfCar; i++) {
            carPositions[i] = 0;
            carStatus[i] = "-";
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        InputView inputView = new InputView(); // 사용자 입력을 위한 객체 생성

        inputView.userInput(racingGame);  //사용자 입력 실행
        racingGame.gameInitialSet(racingGame.getNumberOfCar()); // 유저 입력값을 기반으로 최초 설정값 세팅
    }
}
