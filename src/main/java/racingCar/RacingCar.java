package racingCar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    String inputName; // 자동차 이름 입력 값
    int inputTryNumber; // 경주 시도 횟수 값

    ArrayList<Car> garage; // 차고

    /**
     * 경주 시작
     */
    public void race() {
        inputString();
        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < inputTryNumber; i++) {
            racing();
        }
        chooseWinner();
    }

    /**
     * 우승자 결정
     */
    private void chooseWinner() {
        int max = Integer.MIN_VALUE;
        String winner = "";
        for (Car car : garage) {
            if (car.position > max) {
                max = car.position;
                winner = car.name;
                continue;
            }
            if (car.position == max) {
                winner += "," + car.name;
            }
        }
        System.out.print("최종 우승자:" + winner);
    }

    /**
     * 실제 경주 1회 수행
     */
    private void racing() {
        for (Car car : garage) {
            int move = draw();
            if (move >= 4) {
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
     * 입력값 입력 받는 함수
     */
    void inputString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputName = sc.nextLine();
        System.out.println(inputName);
        // 이름 추출 및 객체 생성 함수
        initCar(inputName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        inputTryNumber = Integer.parseInt(sc.nextLine());
        System.out.println(inputTryNumber);
    }

    /**
     * 자동차 생성하여 차고에 넣는 함수
     *
     * @param inputName 입력값
     */
    private void initCar(String inputName) {
        String[] carNameList = inputName.split(",");
        carNameValidChk(carNameList);
        garage = new ArrayList<>();
        for (int i = 0; i < carNameList.length; i++) {
            Car car = new Car(carNameList[i]);
            garage.add(car);
        }
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
