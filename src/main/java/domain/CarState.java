package domain;

public interface CarState {
    CarState copy();
    int position();
    CarState move(CarDisplacement carDisplacement);
}
