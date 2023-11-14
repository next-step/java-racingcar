package step4.model;

public interface Moving {

    void move(NumberGenerator generator);

    String getDistanceStr(String move);

    int getDistance();

}
