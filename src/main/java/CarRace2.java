import java.util.*;

public class CarRace2 {

/*
주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
자동차 이름은 쉼표(,)를 기준으로 구분한다.
전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----


최종 우승자: pobi, jun
 */

    public static void main(String[] args) {
        race();
    }

    public static void race() {

        // 입력
        //경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
        //pobi,woni,jun
        //시도할 횟수는 몇 회인가요?
        //5

        Scanner sc = new Scanner(System.in);
        System.out.println("input name : ");
        String[] carName= (sc.next()).split(",");
        for(String name : carName){
            if(name.length()>5){
                throw new IllegalArgumentException();
            }
        }
        System.out.println("rotation count : ");
        int rotation = sc.nextInt();
        sc.close();

        List<Car2> carList = new ArrayList<>();
        for (int i = 0; i < carName.length; ++i) {
            carList.add(new Car2(carName[i]));
        }

        System.out.println("result : ");
        for (int i = 0; i < rotation; ++i) {
            // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
            for (Car2 car2 : carList) {
                car2.addDistance(pickRandom());
            }
            // 경기모양 출력
            printRace(carList);
        }

        //Collections.sort(list, Collections.reverseOrder());
        Collections.sort(carList, new Comparator<Car2>() {
            @Override
            public int compare(Car2 o1, Car2 o2) {
                return  o2.getDistance() - o1.getDistance(); // desc
            }
        });

       //order desc
        for (Car2 car2 : carList) {
            System.out.println(" carList : "+ car2.getName()+", "+car2.getDistance());
        }

        List<String> winnerList = new ArrayList<>();
        int maxDistance = carList.get(0).getDistance();
        for (Car2 car2 : carList) {
            if(car2.getDistance() < maxDistance){
                break;
            }
            winnerList.add(car2.getName());
        }


        System.out.println("final winner : " + winnerList.toString());
    }



    public static int pickRandom() {
        Random random = new Random();
        int next = random.nextInt(10);
        if (next >= 4) {
            return 1;
        }
        return 0;
    }

    public static void printRace(List<Car2> carList) {
        for (Car2 car2 : carList) {
            String printStreet = "-";
            String printStreet2 = printStreet.repeat(car2.getDistance());
            System.out.println(car2.getName()+" : "+printStreet2);
        }
        System.out.println("");
    }

}
