package RacingCar;
import java.util.*;

public class RacingCar {

    private static int maxmovecnt = 0;
    private static String winner = "";

    public static void RacingCar () {

        ArrayList<Car> carlist =  new ArrayList<Car>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        String inputValue = scanner.nextLine();
        String[] splitValue = inputValue.split(",");

        for(int i=0; i < splitValue.length; i++) {

            if (splitValue[i].length() > 5)
                throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 한다.");

            carlist.add(new Car(splitValue[i], 0));
        }

        System.out.print("시도할 횟수는 몇 회인가요?\n");
        int count = Integer.parseInt(scanner.nextLine());

        //게임실행
        rungame(carlist, count);
    }


    public static void rungame(List<Car> carlist, int count){

        List<String> winner = new ArrayList<>();

        for(int i=0; i < count; i++) {
            for (Car cars : carlist) {
                cars.Move();
                print(cars.name, cars.move);
                maxmove(cars.move);
            }
            System.out.println();
        }

        for (Car cars : carlist) {
            if(cars.move == maxmovecnt){
                winner.add(cars.name);
            }
        }

        System.out.println(String.format("최종 우승자: " + winner.toString()));
    }

    public static void print(String name, int distance){
        String print = "-";
        System.out.println(name+" : "+print.repeat(distance));
    }

    public static void maxmove(int move){
        if (move > maxmovecnt) {
            maxmovecnt = move;
        }
    }
}