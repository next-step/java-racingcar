package racingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {

    private final int CAR_NAME_MAX_LENGTH = 5;
    private String inputName;
    private int inputTryNumber;

    private List<Car> garage;

    public RacingGame(String inputName, int inputTryNumber) {
        this.inputName = inputName;
        this.inputTryNumber = inputTryNumber;
    }

    public void race() {
        inputStringAndInitCar(inputName, inputTryNumber);

        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < inputTryNumber; i++) {
            racing();
        }

        chooseWinner();
    }

    private void chooseWinner() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : garage) {
            int currentPosition = car.getPosition();
            if (currentPosition >= maxPosition) {
                maxPosition = currentPosition;
                winners.add(car.getName());
            }
        }
        System.out.print("최종 우승자: " + String.join(",", winners));
    }

    private int findMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : garage) {
            int currentPosition = car.getPosition();
            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
            }
        }
        return maxPosition;
    }


    private void racing() {
        for(Car car : garage) {
            car.move();
            car.showPosition();
        }
        System.out.println("");
    }

    void inputStringAndInitCar() {
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

    void inputStringAndInitCar(String inputName, int inputTryNumber) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        System.out.println(inputName);
        // 이름 추출 및 객체 생성 함수
        initCar(inputName);

        System.out.println("시도할 횟수는 몇 회인가요?");
        System.out.println(inputTryNumber);
    }

    private void initCar(String inputName) {
        String[] carNameList = inputName.split(",");

        //자동차 이름은 5자를 초과할 수 없다 - 초과체크 구현
        carNameValidChk(carNameList);

        garage = new ArrayList<>();
        for (int i = 0; i < carNameList.length; i++) {
            Car car = new Car(carNameList[i]);
            garage.add(car);
        }
    }

    private void carNameValidChk(String[] carNameList) {
        List<String> strings = Arrays.stream(carNameList)
            .filter((s) -> s.length() > CAR_NAME_MAX_LENGTH)
            .collect(Collectors.toList());

        if(!strings.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 "+CAR_NAME_MAX_LENGTH+"자를 초과할 수 없습니다. ");
        }
    }
}