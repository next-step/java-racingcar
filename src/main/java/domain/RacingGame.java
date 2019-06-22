package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int timeOfGame; // 자동차 경주 횟수
    private List<CarInfo> car;
    private List<CarInfo> winner;
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

    public List<CarInfo> getCars() {
        return car;
    }

    // 자동차 게임 종료 여부를 확인하는 함수
    public boolean isEnd() {
        return this.timeOfGame < this.indexofTimeofGame;
    }

    // 사용자가 입력한 횟수에 따라서 자동화 게임 실행 함수
    public void race() {

        for (CarInfo elemnt : car) {
            if (this.indexofTimeofGame > 1) {
                elemnt.move();
            }
        }
        ++indexofTimeofGame;
    }

    // 자동차 게임의 우승자를 찾는 함수
    public List<CarInfo> getWinners() {
        winner = new ArrayList<>();

        int maxPosition = findMaxPosition();

        for (CarInfo element : car) {
            if (element.compareWithMaxPosition(maxPosition)) {
                winner.add(element);
            }
        }
        return winner;
    }

    // 자동차의 max position 값을 구하는 함수
    public int findMaxPosition() {
        int maxPosition = 0;

        for (CarInfo element : car) {
            maxPosition = element.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
