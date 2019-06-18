import java.util.Random;

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

    public String[] getCarStatus() {
        return carStatus;
    }

    // 생성된 랜덤값이 4이상일때 자동차 위치를 전진하는 함수
    public void move(int position) {
        carPositions[position] += 1;
        carStatus[position] += "-";

    }

    // 랜덤값 생성 및 자동차 경주 결과를 호출하는 함수
    public void makeRandomNumberAndGameResult(RacingGame racingGame) {
        Random generatorNumber = new Random();
        ResultView resultView = new ResultView(); // 자동차 경주 결과의 출력을 위한 객체 생성
        int result;

        System.out.println("실행 결과");

        for (int i = 0; i < racingGame.getTime(); ++i) {
            for (int j = 0; j < racingGame.getNumberOfCar(); ++j) {

                result = generatorNumber.nextInt(10); // 랜덤값 생성
                if (result >= 4) {
                    move(j); // 자동차 위치 전진 함수 호출
                }
                resultView.disPlayRacingResult(j, racingGame.getCarStatus()); //자동차 경주 결과 출력
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        InputView inputView = new InputView(); // 사용자 입력을 위한 객체 생성

        inputView.userInput(racingGame);  //사용자 입력 실행
        racingGame.gameInitialSet(racingGame.getNumberOfCar()); // 유저 입력값을 기반으로 최초 설정값 세팅
        racingGame.makeRandomNumberAndGameResult(racingGame); //Random 값 생성 및 자동차 상태 출력
    }
}
