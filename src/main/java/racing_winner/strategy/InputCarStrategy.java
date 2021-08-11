package racing_winner.strategy;

public class InputCarStrategy implements CarStrategy{
    private static final int INPUT_MIN = 1;
    private static final int INPUT_MAX = 5;

    @Override
    public boolean isUsable(String name) {
        int length = name.length();
        if(length < INPUT_MIN || length > INPUT_MAX){
            return false;
        }
        return true;
    }

    @Override
    public boolean isUsable(int distance) {
        return !(distance < INPUT_MIN);
    }
}
