package racingCar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {
    final static String DELIMITER = ",";

    public void startGame(){
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
        System.out.println(getWinners(carList));
    }
    public List<Car> makeCarList(String carNames) {
        String[] carNameArr = carNames.trim().split(DELIMITER);
        List<Car> carList = Arrays.stream(carNameArr).map(carName -> new Car(carName, 0)).collect(Collectors.toList());

        return carList;
    }

    public void excuteCarRacing(List<Car> carList) {
        carList.forEach(car -> {
            int randonNumber = new Random().nextInt(10);
            car.move(randonNumber);
            System.out.print("\n"+car.getName()+" : ");
            printLocation(car.getPosition());
        });

        System.out.println("");
    }

    private void printLocation(int location) {
        for(int i=0;i<location;i++){
            System.out.print("-");
        }
    }

    public String getWinners(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        OptionalInt maxValue = carList.stream().mapToInt(Car::getPosition).max();
        carList.stream().filter(car->(car.getPosition() == maxValue.getAsInt())).forEach( car -> winnerList.add(car.getName()));

        return String.join(",",winnerList);
    }
};

