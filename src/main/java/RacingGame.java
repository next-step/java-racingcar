import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private int timeOfGame; // 자동차 경주 횟수
    private int numberOfCar;    // 자동차 대수
    public static int MAX_RANDOM_NUMBER = 10;

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
    public void gameInitialSet(int numberOfCar, ArrayList<CarInfo> carInfo) {
        if(carInfo == null)
            throw new NullPointerException("함수의 인자값이 Null값이니다. 확인하시고 다시 실행해주시길 바랍니다.");

        if(numberOfCar <= 1)
            throw  new IllegalArgumentException("입력하신 자동차의 숫자가 0이거나 1입니다. 다시 입력해주세요");

        for (int i = 0; i < carInfo.size(); i++)
            carInfo.get(i).setCarPositions(0);

    }

    // 생성된 랜덤값이 4이상일때 자동차 위치를 전진하는 함수
    public void move(int position, ArrayList<CarInfo> carInfo) {
        int prePosition = carInfo.get(position).getCarPosition();
        carInfo.get(position).setCarPositions(prePosition+1);
    }

    // 랜덤값 생성 및 자동차 경주 결과를 호출하는 함수
    public void makeRandomNumberAndGameResult(RacingGame racingGame, ArrayList<CarInfo> carInfo) {
        Random generatorNumber = new Random();
        ResultView resultView = new ResultView(); // 자동차 경주 결과의 출력을 위한 객체 생성
        int randomResult;

        if (racingGame == null || carInfo == null || generatorNumber == null || resultView == null)
            throw new NullPointerException("함수의 객체 중에 null값이 있습니다. 확인하시고 다시 실행해주시길 바랍니다.");

        System.out.println("실행 결과");
        for (int i = 0; i < racingGame.getTime(); ++i) {
            for (int j = 0; j < carInfo.size(); ++j) {
                randomResult = generatorNumber.nextInt(MAX_RANDOM_NUMBER); // 랜덤값 생성
                if (i == 0 || randomResult >= 4) {  // 무조건 최초 1회 && 랜덤값이 4이상 이면 전진 실행되도록
                    move(j, carInfo); // 자동차 위치 전진 함수 호출
                }
                resultView.disPlayRacingResult(carInfo.get(j)); //자동차 경주 결과 출력
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        ArrayList<CarInfo> carInfo = new ArrayList<>();
        InputView inputView = new InputView(); // 사용자 입력을 위한 객체 생성


        inputView.userInput(racingGame, carInfo);  //사용자 입력 실행
        racingGame.gameInitialSet(racingGame.getNumberOfCar(), carInfo); // 유저 입력값을 기반으로 최초 설정값 세팅
        racingGame.makeRandomNumberAndGameResult(racingGame, carInfo); //Random 값 생성 및 자동차 상태 출력
    }
}
