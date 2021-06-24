package racing.racingrebuild;

import java.util.*;

public class NewRacing {
    DoSomething doSomething = new DoSomething();
    //쪼개는 함수
    public ArrayList<Car> splitName(String allName) {
        ArrayList<Car> car = new ArrayList<>();


        String[] array = allName.split(",");
        for (int i = 0; i < array.length; i++) {
            doSomething.excess(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            car.add(new Car(array[i]));
        }
        System.out.println(car);
        return car;
    }



    //레이스중
    private ArrayList<Car> doRace(ArrayList<Car> splitName) {
        int[] plushyphen = doSomething.randomNumber(splitName.size());
        String[] str = new String[splitName.size()];
        DoSomething doSomthing = new DoSomething();
        if (plushyphen != null) {
            for (int i = 0; i < splitName.size(); i++) {
                splitName.get(i).move(plushyphen[i]);
                str[i] = doSomthing.createRoad(splitName.get(i));
            }
            for (int i = 0; i < splitName.size(); i++) {
                System.out.println(splitName.get(i).getCarName()+":"+str[i]);
            }
        }
        System.out.println("=============================");
        return splitName;
    }



    public ArrayList<Car> raceStart(String name, int count) {
        ArrayList<Car> spName = splitName(name);

        for (int j = 0; j < count; j++) {
            doRace(spName);
        }
        return spName;
    }

    public List<Car> winner(ArrayList<Car> cars){
        List<Integer> number = new ArrayList<>();
        ArrayList<Car> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            number.add(cars.get(i).getLocation());
        }
        int max = number.stream().max(Integer::compare).orElse(-1);
        System.out.println(max);

        for (int i = 0; i <cars.size() ; i++) {
            if (cars.get(i).getLocation() == max){
                winners.add(new Car(cars.get(i).getCarName(),cars.get(i).getLocation()));
            }
        }
        System.out.print("승리자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getCarName()+ " ");
        }

//        cars.sort(Comparator.comparingInt(Car::getLocation));
        return winners;
    }
}
