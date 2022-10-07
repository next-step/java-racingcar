package racing.core;

import java.util.Objects;

public class ClientInput {
    private final int carCount;
    private final int tryCount;

    public ClientInput(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInput that = (ClientInput) o;
        return carCount == that.carCount && tryCount == that.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carCount, tryCount);
    }

    public static ClientInput.ClientInputBuilder builder(){
        return new ClientInput.ClientInputBuilder();
    }

    public static class ClientInputBuilder {
        private int carCount;
        private int tryCount;

        ClientInputBuilder() {
        }

        public ClientInput.ClientInputBuilder carCount(int carCount){
            this.carCount = carCount;
            return this;
        }

        public ClientInput.ClientInputBuilder tryCount(int tryCount){
            this.tryCount = tryCount;
            return this;
        }

        public ClientInput build(){
            return new ClientInput(this.carCount, this.tryCount);
        }
    }
}
