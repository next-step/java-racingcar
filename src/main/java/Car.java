/**
 * @author jeongheekim
 * @date 3/25/24
 */
public abstract class Car {
    protected String status = "";

    protected String name = "";


    public abstract void drive(int num, String delimiter);

    public abstract int getNumber();

    public String getStatus() {
        return this.status;
    }

    public String getName() {
        return this.name;
    }

    public Car(String name) {
        this.name = name;
    }

}
