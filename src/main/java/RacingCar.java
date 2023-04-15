import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    static String move = "-";

    static List<Car> recordMovingCar = new ArrayList<>();

    public static void main(String[] args) {

        InputView userInput = scannerInput();

        int numberOfCarsValue = userInput.getNumberOfCars();
        int numberOfAttemptsValue = userInput.getNumberOfAttempts();

        System.out.println("======= READY =========");
        for (int carNumber=0; carNumber < numberOfCarsValue; carNumber++) { System.out.println(move); }

        System.out.println("======= START!! =======");
        randomMove(numberOfCarsValue, numberOfAttemptsValue);

    }

    public static void randomMove(int numberOfCarsValue, int numberOfAttemptsValue) {
        Random random = new Random();

        for (int attempt=0; attempt < numberOfAttemptsValue; attempt++) {
            for (int eachCar = 0; eachCar < numberOfCarsValue; eachCar++) {

                int randomValueForMove = random.nextInt(numberOfAttemptsValue);

                String move = "-";
                Car car = new Car();
                car.setMoving(move);
                recordMovingCar.add(car);

                String beforeMoving = "";

//                System.out.println("랜덤 값 : " + randomValueForMove);

                if (randomValueForMove > 9 || randomValueForMove < 4) {
                    beforeMoving = recordMovingCar.get(eachCar).getMoving();
                    String doNotMove = beforeMoving + moving(randomValueForMove);
                    car.setMoving(doNotMove);
                }


                if (randomValueForMove > 0 & randomValueForMove > 3 & randomValueForMove <= 9) {
                    beforeMoving = recordMovingCar.get(eachCar).getMoving();
                    String plusMoving = beforeMoving + moving(randomValueForMove);
                    car.setMoving(plusMoving);
                }

                recordMovingCar.add(car);
                recordMovingCar.get(eachCar).setMoving(car.getMoving());
                System.out.println(recordMovingCar.get(eachCar).getMoving());
            }
            System.out.print(System.lineSeparator());
        }
    }

    public static String moving(int randomValueForMove) {
        String move = "-";

        if (randomValueForMove > 9 || randomValueForMove < 4) {
            move = "";
            return move;
        }

        for (int number=0; number < randomValueForMove; number++) { move = move + "-";}

        return move;
    }

    public static InputView scannerInput() {

        InputView inputView = new InputView();
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        inputView.setNumberOfCars(scanner.nextInt());

        System.out.println("시도 횟수는 몇 회인가요?");
        inputView.setNumberOfAttempts(scanner.nextInt());

        return inputView;
    }

}





















