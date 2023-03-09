package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCar {

    final static int nameLength = 5;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        List<Car> carList = makeCarList(carNames);

        System.out.println("\n시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();
        scanner.close();

        System.out.print("\n실행 결과");
        for(int i=0;i<count;i++) {
            excuteCarRacing(carList);
        }

        System.out.print("\n최종 우승자 : ");
        System.out.println(getWinners(carList,count));

    }
    public static List<Car> makeCarList(String carNames) {
        List<String> carNameList = makeCarNameList(carNames);
        List<Car> carList = new ArrayList<>();

        carNameList.stream().forEach(carName -> {
            Car car = new Car(carName,0);
            carList.add(car);
        });

        return carList;
    }

    public static List<String> makeCarNameList(String carNames) {
        String[] carNameArr = carNames.split(",");
        Arrays.stream(carNameArr).filter(carName -> (carName.length()>nameLength)).forEach(carName -> {
            throw new StringIndexOutOfBoundsException("자동차 이름은 5자를 초과할 수 없습니다.");
        });

        return Arrays.stream(carNameArr).collect(Collectors.toList());
    }

    public static void excuteCarRacing(List<Car> carList) {
        carList.stream().forEach(car -> {
            int cnt = (int)(Math.random() * 9);
            if(cnt>=4) car.location += 1;

            System.out.print("\n"+car.name+" : ");
            printLocation(car.location);
        });

        System.out.println("");
    }

    private static void printLocation(int location) {
        for(int i=0;i<location;i++){
            System.out.print("-");
        }
    }

    public static String getWinners(List<Car> carList, int count) {
        List<String> winnerList = new ArrayList<>();
        carList.stream().filter(car->(car.location==count)).forEach(car -> {winnerList.add(car.name);});

        return String.join(",",winnerList);
    }
}
