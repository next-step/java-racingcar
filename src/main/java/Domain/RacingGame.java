package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import View.*;

public class RacingGame {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_POINT_NUMBER = 4;

    private int timeOfGame; // 자동차 경주 횟수

    public RacingGame() {
    }

    public RacingGame(int timeOfGame) {
        this.timeOfGame = timeOfGame;
    }

    public int getTime() {
        return timeOfGame;
    }

    // 자동차 경주의 최초 설정 세팅 함수
    public void gameInitialSet(List<CarInfo> carInfo) {
        if (carInfo == null)
            throw new NullPointerException("함수의 인자값이 Null값이니다. 확인하시고 다시 실행해주시길 바랍니다.");

        for (int i = 0; i < carInfo.size(); i++) {
            carInfo.get(i).setCarPositions(0);
        }
    }

    // 생성된 랜덤값이 4이상일때 자동차 위치를 전진하는 함수
    public void move(int numberOfCar, List<CarInfo> carInfo) {
        if (carInfo == null)
            throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");

        int prePosition = carInfo.get(numberOfCar).getCarPosition();
        carInfo.get(numberOfCar).setCarPositions(prePosition + 1);
    }

    // 랜덤값 생성 및 자동차 경주 결과를 호출하는 함수
    public void makeRandomNumberAndGameResult(RacingGame racingGame, List<CarInfo> carInfo) {
        if (racingGame == null || carInfo == null)
            throw new NullPointerException("함수의 객체 중에 null값이 있습니다. 확인하시고 다시 실행해주시길 바랍니다.");

        System.out.println("실행 결과");
        for (int numberOfRace = 0; numberOfRace < racingGame.getTime(); ++numberOfRace) {
            for (int numberOfCar = 0; numberOfCar < carInfo.size(); ++numberOfCar) {
                decideMoveOrStop(makeRandomNumber(), numberOfRace, numberOfCar, carInfo); // 자동차 전진 혹은 유지 여부 실행
                ResultView.disPlayRacingResult(carInfo.get(numberOfCar)); //자동차 경주 결과 출력
            }
            System.out.println("\n");
        }
    }

    // 랜덤번호 생성 함수
    public int makeRandomNumber() {
        Random generatorNumber = new Random();
        return generatorNumber.nextInt(MAX_RANDOM_NUMBER);
    }

    // 랜덤번호의 결과에 따라서 자동차 위치의 전진 혹은 유지를 결정하는 함수
    public void decideMoveOrStop(int randomNumber, int numberOfRace, int numberOfCar, List<CarInfo> carInfo) {
        if (carInfo == null)
            throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");

        if (numberOfRace == 0 || randomNumber >= MOVE_POINT_NUMBER) // 첫번째 게임 or 랜덤값의 결과가 4이상이면 자동차 전진실행
            move(numberOfCar, carInfo);
    }

    // 자동차 게임 우승자 판정 함수
    public void findRaceWinner(List<CarInfo> carInfo) {
        int winnerPosition = 0;
        String winnerNames = "";

        if (carInfo == null)
            throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");

        for (int i = 0; i < carInfo.size(); ++i) // 우승자의 위치값 찾기
            if (winnerPosition < carInfo.get(i).getCarPosition())
                winnerPosition = carInfo.get(i).getCarPosition();

        for (int i = 0; i < carInfo.size(); ++i) // 우승자의 이름 정보 찾기
            if (winnerPosition == carInfo.get(i).getCarPosition())
                winnerNames += carInfo.get(i).getCarName() + ",";

        ResultView.disPlayRaceWinner(winnerNames); // 최종 우승자 화면 출력 실행
    }

    public static void main(String[] args) {
        RacingGame racingGame;
        List carInfoList = new ArrayList<CarInfo>();

        racingGame = InputView.userInput(carInfoList);  //사용자 입력 실행
        racingGame.gameInitialSet(carInfoList); // 유저 입력값을 기반으로 최초 설정값 세팅
        racingGame.makeRandomNumberAndGameResult(racingGame, carInfoList); //Random 값 생성 및 자동차 상태 출력
        racingGame.findRaceWinner(carInfoList); // 최총 우승자 찾기 실행
    }
}
