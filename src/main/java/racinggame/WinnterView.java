package racinggame;

import java.util.List;
import java.util.stream.Collectors;

public class WinnterView {

    public void print(List<String> victoryCar)  {
        String victoryCarName = victoryCar.stream().collect(Collectors.joining(","));
        System.out.println(victoryCarName + "가 최종 우승했습니다.");
    }
}
