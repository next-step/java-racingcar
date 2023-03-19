package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private String inputName;
    private int inputTryNumber;

    private List<Car> garage;

    public RacingGame(String inputName, int inputTryNumber) {
        this.inputName = inputName;
        this.inputTryNumber = inputTryNumber;
        inputStringAndInitCar(this.inputName, this.inputTryNumber);
    }

    public RacingGame() {
        inputStringAndInitCar();
    }

    public void race() {
        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < inputTryNumber; i++) {
            racing();
        }

        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();
        winners = new Winner().getWinner(maxPosition, garage);
        new PrintCarNames().printWinners(winners);
    }

    private void racing() {
        for (Car car : garage) {
            final int drawNumber = car.draw();
            car.move(drawNumber);
            new PrintCarNames().showPosition(car.getName(), car.getPosition());
        }
        System.out.println("");
    }

    public int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : garage) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private void inputStringAndInitCar() {
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

    private void inputStringAndInitCar(String inputName, int inputTryNumber) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        System.out.println(inputName);
        // 이름 추출 및 객체 생성 함수
        initCar(inputName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        System.out.println(inputTryNumber);
    }

    private void initCar(String inputName) {
        String[] carNameList = inputName.split(",");

        garage = new ArrayList<>();
        for (int i = 0; i < carNameList.length; i++) {
            Car car = new Car(carNameList[i]);
            garage.add(car);
        }
    }
}