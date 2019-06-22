package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import view.*;

public class RacingGame {

    private int timeOfGame; // 자동차 경주 횟수
    public List<CarInfo> car;
    private int indexofTimeofGame = 1;

    // 사용자 입력에 따라서 실행되는 RaceGame 생성자
    public RacingGame(String namesOfCar, int timeofGame) {
        String[] inputnamesOfCar = checkNameOfCar(splitName(namesOfCar));
        this.car = new ArrayList<>();
        CarInfo inputCarInfo;

        for (int i = 0; i < inputnamesOfCar.length; ++i) {
            inputCarInfo = new CarInfo(inputnamesOfCar[i]); //입력된 자동차 이름으로 CarInfo 생성하여 List에 추가
            this.car.add(inputCarInfo);
        }

        this.timeOfGame = timeofGame;
    }

    // 사용자에게 입력받은 자동차 이름을 문자 "," 기준으로 split하는 함수
    private String[] splitName(String names) {
        return names.split(",");
    }

    // 사용자가 입력한 공백 문자 혹은 개행문자가 포함되었는지 체크하는 함수
    private String[] checkNameOfCar(String[] inputStrings) {
        for (int i = 0; i < inputStrings.length; ++i) {
            if (inputStrings[i].isEmpty() || inputStrings[i].equals(" ") || inputStrings[i].equals("\n")) {
                throw new IllegalArgumentException("입력값이 잘못되었습니다. 자동차 이름을 다시 한번 입력해주세요.");
            }
        }
        return inputStrings;
    }


    public List<CarInfo> getCars(){
        return this.car;
    }

//    // 자동차 경주의 최초 설정 세팅 함수
//    public void gameInitialSet(List<CarInfo> carInfo) {
//        if (carInfo == null)
//            throw new NullPointerException("함수의 인자값이 Null값이니다. 확인하시고 다시 실행해주시길 바랍니다.");
//
//        for (int i = 0; i < carInfo.size(); i++) {
//            carInfo.get(i).setCarPositions(0);
//        }
//    }

    // 생성된 랜덤값이 4이상일때 자동차 위치를 전진하는 함수
    public void move(int numberOfCar, List<CarInfo> carInfo) {
        if (carInfo == null)
            throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");

        int prePosition = carInfo.get(numberOfCar).getCarPosition();
        carInfo.get(numberOfCar).setCarPositions(prePosition + 1);
    }

//    // 랜덤값 생성 및 자동차 경주 결과를 호출하는 함수
//    public void makeRandomNumberAndGameResult(RacingGame racingGame, List<CarInfo> carInfo) {
//        if (racingGame == null || carInfo == null)
//            throw new NullPointerException("함수의 객체 중에 null값이 있습니다. 확인하시고 다시 실행해주시길 바랍니다.");
//
//        System.out.println("실행 결과");
//        for (int numberOfRace = 0; numberOfRace < racingGame.getTime(); ++numberOfRace) {
//            for (int numberOfCar = 0; numberOfCar < carInfo.size(); ++numberOfCar) {
//                decideMoveOrStop(makeRandomNumber(), numberOfRace, numberOfCar, carInfo); // 자동차 전진 혹은 유지 여부 실행
//                ResultView.disPlayRacingResult(carInfo.get(numberOfCar)); //자동차 경주 결과 출력
//            }
//            System.out.println("\n");
//        }
//    }

//    // 랜덤번호 생성 함수
//    public int makeRandomNumber() {
//        Random generatorNumber = new Random();
//        return generatorNumber.nextInt(MAX_RANDOM_NUMBER);
//    }

//    // 랜덤번호의 결과에 따라서 자동차 위치의 전진 혹은 유지를 결정하는 함수
//    public void decideMoveOrStop(int randomNumber, int numberOfRace, int numberOfCar, List<CarInfo> carInfo) {
//        if (carInfo == null)
//            throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");
//
//        if (numberOfRace == 0 || randomNumber >= MOVE_POINT_NUMBER) // 첫번째 게임 or 랜덤값의 결과가 4이상이면 자동차 전진실행
//            move(numberOfCar, carInfo);
//    }
//
//    // 자동차 게임 우승자 판정 함수
//    public void findRaceWinner(List<CarInfo> carInfo) {
//        int winnerPosition = 0;
//        String winnerNames = "";
//
//        if (carInfo == null)
//            throw new NullPointerException("객체 carInfo가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");
//
//        for (int i = 0; i < carInfo.size(); ++i) // 우승자의 위치값 찾기
//            if (winnerPosition < carInfo.get(i).getCarPosition())
//                winnerPosition = carInfo.get(i).getCarPosition();
//
//        for (int i = 0; i < carInfo.size(); ++i) // 우승자의 이름 정보 찾기
//            if (winnerPosition == carInfo.get(i).getCarPosition())
//                winnerNames += carInfo.get(i).getCarName() + ",";
//
//        ResultView.disPlayRaceWinner(winnerNames); // 최종 우승자 화면 출력 실행
//    }

    // 자동차 게임 종료 여부를 확인하는 함수
    public boolean isEnd() {
        return this.timeOfGame < this.indexofTimeofGame;
    }

    // 사용자가 입력한 횟수에 따라서 자동화 게임 실행 함수
    public void race() {
        for (CarInfo elemnt : car) {
            elemnt.move();
        }
        ++indexofTimeofGame;
    }

}
