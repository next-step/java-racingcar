package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<Car> inputCars() {

        List<Car> cars =  new ArrayList<Car>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        String inputValue = scanner.nextLine();
        String[] splitValue = inputValue.split(",");

        for(int i=0; i < splitValue.length; i++) {
            cars.add(new Car(splitValue[i]));
        }

        return cars;
    }

    public static int inputGameCnt() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회인가요?");

        int gameCount = Integer.parseInt(scanner.nextLine());

        return gameCount;
    }
}
