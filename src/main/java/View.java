import java.util.Scanner;

public class View {
    Car car = new Car();
    Scanner scanner = new Scanner(System.in);

    public void enterCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carsName = scanner.next();
        car.splitCarsName(carsName);
    }

    public int enterGameTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        int gameTurn = scanner.nextInt();
        System.out.println();
        return gameTurn;
    }

    //여기가 출력이 안됨.
    public void printTurnResult() {
        for (int i = 0; i < Car.cars.size(); i++) {
            String carName = Car.cars.get(i);
            String carMoving = Car.carsMoving.get(i);
            System.out.println(carName + " : " + carMoving);
        }
        System.out.println();
    }

    public void printWinnerResult() {
        for (int i = 0; i < Car.winner.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(Car.winner.get(i));
        }
        System.out.println("가 최종 우승했습니다");
    }
}
