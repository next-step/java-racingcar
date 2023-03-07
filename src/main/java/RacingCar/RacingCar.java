package RacingCar;
import java.util.*;

public class RacingCar {

    public static void main(String[] args){

        ArrayList<Car> carlist =  new ArrayList<Car>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        String inputValue = scanner.nextLine();
        String[] splitValue = inputValue.split(",");

        for(int i=0; i < splitValue.length; i++) {
            carlist.add(new Car(splitValue[i]));
        }

        System.out.print("시도할 횟수는 몇 회인가요?\n");
        int count = Integer.parseInt(scanner.nextLine());

        //게임실행
        rungame(carlist, count);
        //우승자 확인
        getwinner(carlist);

    }

    public static void rungame(List<Car> carlist, int count){

        for(int i=0; i < count; i++) {
            for (Car cars : carlist) {
                cars.Move(cars.randomcnt());
                printrace(cars.name, cars.move);
            }
            System.out.println();
        }

    }

    public static void getwinner(List<Car> carlist){

        List<String> winner = new ArrayList<>();
        int maxmove = getmaxmove(carlist);

        for (Car cars : carlist) {
            if (cars.move == maxmove) {
                winner.add(cars.name);
            }
        }

        System.out.println(String.format("최종 우승자: " + winner.toString()));
    }

    public static void printrace(String name, int move){
        String print = "-";
        System.out.println(name+" : "+print.repeat(move));
    }

    public static int getmaxmove(List<Car> carlist){

        int maxmovecnt = 0;

        for (Car cars : carlist) {
            if (cars.move > maxmovecnt) {
                maxmovecnt = cars.move;
            }
        }

        return maxmovecnt;
    }
}