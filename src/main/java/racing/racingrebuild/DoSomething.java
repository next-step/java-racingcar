package racing.racingrebuild;

import java.util.Random;

public class DoSomething {
    //5글자인지 판단하는 함수 (5글자 초과면 4글자로 자르기)
    public String excess(String name) {
        if (name.length() > 4) {
            name = name.substring(0, 4);
            System.out.println(name);
            return name;
        } else {
            return name;
        }
    }

    //하이픈 생성
    public String createRoad(Car splitName) {
        String str = "";
        for (int i = 0; i <splitName.getLocation() ; i++) {
            str+="-";
        }
        return str;
    }

    //무작위 값 구하기(조건 0에서 9)
    public int[] randomNumber(int i) {
        Random random = new Random();
        int[] location = new int[i];

        for (int j = 0; j < i; j++) {
            location[j] = random.nextInt(10);
        }

        return location;
    }
}
