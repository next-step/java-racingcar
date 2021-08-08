package racing_winner.strategy;

public class InputCarStrategy implements CarStrategy{
    private static final int NAME_MIN = 1;
    private static final int NAME_MAX = 5;

    @Override
    public boolean isUsable(String name) {
        int length = name.length();
        if(length < NAME_MIN || length > NAME_MAX){
            return false;
        }
        return true;
    }
}
