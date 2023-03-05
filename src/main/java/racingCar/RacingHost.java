package racingCar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingHost {

    String inputName; // 자동차 이름 입력 값
    int inputTryNumber; // 경주 시도 횟수 값
    ArrayList<Car> garage; // 차고

    int FORWARD_CONDITION = 4; // 자동차 전진 조건

    /**
     * 경주를 위한 자동차 객체 생성 및 자동차 저장 객체 리턴 함수
     *
     * @param inputName 사용자 입력 값.
     * @return
     */
    private ArrayList<Car> initCar(String inputName) {
        String[] carNameList = inputName.split(",");
        carNameValidChk(carNameList);
        ArrayList<Car> garage = new ArrayList<>();
        for (int i = 0; i < carNameList.length; i++) {
            Car car = new Car(carNameList[i]);
            garage.add(car);
        }
        return garage;
    }

    /**
     * 사용자의 입력 값을 받아 저장하는 함수
     *
     */
    void inputString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputName = sc.nextLine();
        System.out.println(inputName);
        // 이름 추출 및 객체 생성 함수
        garage = initCar(inputName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        inputTryNumber = Integer.parseInt(sc.nextLine());
        System.out.println(inputTryNumber);
    }

    /**
     * 실제 경주 1회 수행
     */
    void racing(ArrayList<Car> garage) {
        for (Car car : garage) {
            if (draw() >= FORWARD_CONDITION) {
                car.forward();
            }
            car.showPosition();
        }
        System.out.println("");
    }

    /**
     * 0-9 랜덤 뽑기
     *
     * @return
     */
    private int draw() {
        Random ran = new Random();
        return ran.nextInt(9);
    }

    /**
     * 우승자 결정
     */
    void chooseWinner(ArrayList<Car> garage) {
        int max = Integer.MIN_VALUE;
        String winner = "";
        for (Car car : garage) {
            if (car.isAheadOf(max)) {
                max = car.position;
                winner = car.name;
                continue;
            }
            if (car.isEqualOf(max)) {
                winner += "," + car.name;
            }
        }
        System.out.print("최종 우승자:" + winner);
    }


    /**
     * 이름 예외 처리 함수
     *
     * @param carNameList 자동차 이름 리스트
     */
    private void carNameValidChk(String[] carNameList) {
        for (int i = 0; i < carNameList.length; i++) {
            if (carNameList[i].length() > 5) {
                throw new IllegalArgumentException(carNameList[i] + " 자동차 이름은 5자를 초과할 수 없습니다. ");
            }
        }

    }
}
