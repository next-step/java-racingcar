import java.util.Scanner;

public class InputView {

    private int cars;
    private int count;


    public void setting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        cars = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        count = scanner.nextInt();
    }


    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < cars; i++) {
            final Car car = new Car();
            System.out.println();
            System.out.println("car = " + car);

            for (int j = 0; j < count; j++) {
                car.move(RandomGenerator.create());
                System.out.println("result: " + car.print());
            }
        }
    }

}
