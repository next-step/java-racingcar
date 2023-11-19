package racingCar.domain;

import java.util.Objects;

public class Forward {
    private int forwardCount;

    Forward(int forwardCount){
        this.forwardCount = forwardCount;
    }

    public int forwardCount(){
        return this.forwardCount;
    }

    public int returnMaxCount(int maxForwardCount) {
        if(forwardCount >= maxForwardCount) return forwardCount;
        return maxForwardCount;
    }

    public void addForwardCount(){
        this.forwardCount ++;
    }

    public boolean matchMaxForwardCount(int forwardCount){
        return this.forwardCount == forwardCount;
    }

    @Override
    public String toString() {
        return "Forward{" +
                "forwardCount=" + forwardCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forward forward = (Forward) o;
        return forwardCount == forward.forwardCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(forwardCount);
    }
}
