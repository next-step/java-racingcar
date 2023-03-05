package racingcar;

public class racing_game {

    String play(String cars,int track) {

        String[] car_group = cars.split(",");
        car[] ca = new car[car_group.length];

        int max_race = 0;
        String result = "";

        //car 객채 생성
        for (int i = 0; i < car_group.length; i++)
            ca[i] = new car(car_group[i]);

        // game 실행
        System.out.println("실행 결과");
        for (int i = 0; i < track; i++) {
            for (int j = 0; j < car_group.length; j++) {
                ca[j].go();
                ca[j].showrace();
            }
            System.out.println("");
        }

        // 1등race 검색
        for (int i = 0; i < car_group.length; i++)
            if(max_race < ca[i].result())
                max_race=ca[i].result();

        //결과 생성
        for (int i = 0; i < car_group.length; i++)
            if (ca[i].result() == max_race)
                result += ca[i].name() + ", ";

        return result.substring(0,result.length()-2);
    }
}