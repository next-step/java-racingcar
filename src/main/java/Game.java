import java.util.Scanner;

/**
 * @author jeongheekim
 * @date 3/12/24
 */

public class Game {

    public static final String DELIMETER = "-";

    public static final String CAR_NAME_DELIMETER = ",";

    private int gameCount;
  
    private Car[] cars;

    public void start() {

        cars = createCar();

        gameCount = getGameCount();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            job();
        }

        Winner winner = new Winner();
        System.out.println(FormattingUtil.formattingResult(winner.getWinners(cars)) + "가 최종 우승했습니다.");

    }

    private void job() {
        for (Car car : this.cars) {
            car.drive(car.getNumber(), DELIMETER);
            System.out.println(car.getName() + ":" + car.getStatus());
        }
        System.out.println("                           ");
    }

    private int getGameCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
      
        int gameCount = scanner.nextInt();
        System.out.println(gameCount);
      
        return gameCount;
    }


    private Car[] createCar() {
        String[] carNameInputArr = getCarNameInputArr();
        int length = carNameInputArr.length;
        Car[] cars = new Car[length];
        for (int i = 0; i < length; i++) {
            cars[i] = new SmallCar(carNameInputArr[i]);

        }
        return cars;
    }


    private String[] getCarNameInputArr() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 " + CAR_NAME_DELIMETER + "를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String carNameInput = scanner.nextLine();
        System.out.println(carNameInput);
        return carNameInput.split(CAR_NAME_DELIMETER);
    }

    public Car[] getCars() {
        return this.cars;
    }
}

