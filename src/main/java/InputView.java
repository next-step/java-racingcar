//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class InputView {
//
//    private int totalOfCars;
//    private int count;
//
//
//    public void inputGuideNumber() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("자동차 대수는 몇 대 인가요?");
//        totalOfCars = scanner.nextInt();
//
//        System.out.println("시도할 회수는 몇 회 인가요?");
//        count = scanner.nextInt();
//    }
//
//
//    public void printResult() {
//        System.out.println();
//        System.out.println("실행 결과");
//
//        List<Car> cars = new ArrayList<>();
//        for (int i = 0; i < totalOfCars; i++) {
//            cars.add(new Car());
//        }
//
//        for (int i = 0; i < count; i++) {
//            for (int j = 0; j < totalOfCars; j++) {
//                Car car = cars.get(j);
//                car.move(RandomGenerator.create());
//
//                System.out.println(car.print());
//            }
//            System.out.println();
//        }
//    }
//}
