package racingcar_first;

class Racing_Game {

    String play(String cars, int track) {

        String[] car_group = cars.split(",");
        Car[] Cars = new Car[car_group.length];

        int max_race = 0;
        String result = "";

        //car 객채 생성
        for (int i = 0; i < car_group.length; i++)
            Cars[i] = new Car(car_group[i]);

        // game 실행
        System.out.println("실행 결과");
        for (int i = 0; i < track; i++) {
            for (int j = 0; j < car_group.length; j++) {
                Cars[j].go();
                Cars[j].showrace();
            }
            System.out.println("");
        }

        // 1등race 검색
        for (int i = 0; i < car_group.length; i++)
            if (max_race < Cars[i].result())
                max_race = Cars[i].result();

        //결과 생성
        for (int i = 0; i < car_group.length; i++)
            if (Cars[i].result() == max_race)
                result += Cars[i].name() + ", ";

        return result.substring(0, result.length() - 2);
    }
}
