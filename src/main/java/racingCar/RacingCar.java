package racingCar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {
    final static String DELIMITER = ",";

    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        racingCar.startRacing();
    }

    public void startRacing(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        List<Car> carMember = makeCarMember(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();
        scanner.close();

        System.out.print("\n실행 결과");
        for(int i=0;i<count;i++) {
            startCarRacing(carMember);
        }

        System.out.print("\n최종 우승자 : ");
        System.out.println(getWinnersName(carMember));
    }
    public List<Car> makeCarMember(String carNames) {
        String[] carNameArray = carNames.trim().split(DELIMITER);
        List<Car> carList = Arrays.stream(carNameArray).map(carName -> new Car(carName, 0)).collect(Collectors.toList());
        return carList;
    }

    public void startCarRacing(List<Car> carList) {
        carList.forEach(car -> {
            int randomNumber = new Random().nextInt(10);
            car.move(randomNumber);
            System.out.print("\n"+car.getName()+" : ");
            printLocation(car.getPosition());
        });
    }

    private void printLocation(int location) {
        for(int i=0;i<location;i++){
            System.out.print("-");
        }
    }

    public String getWinnersName(List<Car> carList) {
        List<String> winnersList = new ArrayList<>();
        OptionalInt maxValue = carList.stream().mapToInt(Car::getPosition).max();
        carList.stream().filter(car->(car.getPosition() == maxValue.getAsInt())).forEach( car -> winnersList.add(car.getName()));

        return String.join(",",winnersList);
    }
}