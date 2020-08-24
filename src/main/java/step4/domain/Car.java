package step4.domain;
import java.util.ArrayList;
import java.util.List;

public class Car {
    public static final int OWNER_MAX_LENGTH = 5;
    private final String owner;
    private List<String> status = new ArrayList<>();

    public Car(String owner) {
        if(owner.length() > OWNER_MAX_LENGTH) {
            throw new IllegalArgumentException("Exceed max owner name length");
        }
        this.owner = owner;
    }

    public void run(int randomNum) {
        if(isRunable(randomNum)) {
            status.add("-");
        }

        printStatus();
    }

    private void printStatus() {
        StringBuilder strStatus = new StringBuilder();

        status.forEach(strStatus::append);

        System.out.println(owner+" : "+strStatus.toString());
    }

    public int getCurrentStatus() {
        return status.size();
    }

    public String getOwner() {
        return owner;
    }

    private boolean isRunable(int randomNum) {
        return randomNum >= 4;
    }

    public boolean isWinner(int maxStatusSize){
        return status.size() == maxStatusSize;
    }
}
