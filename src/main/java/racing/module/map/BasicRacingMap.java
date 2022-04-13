package racing.module.map;

import java.util.ArrayList;
import java.util.List;

public class BasicRacingMap implements RacingMap{

    private static final StringBuilder sb = new StringBuilder();
    private List<String> map = new ArrayList<>();

    public BasicRacingMap() {}

    @Override
    public void drawCar(int currentPosition) {
        for(int i = 0; i < currentPosition; i++){
            sb.append("-");
        }
        map.add(sb.toString());
        clearStringBuilder(sb);
    }

    private void clearStringBuilder(StringBuilder sb){
        sb.setLength(0);
    }

    public List<String> getMap(){
        return this.map;
    }

}
