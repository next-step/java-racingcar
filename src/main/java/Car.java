/**
 * @author jeongheekim
 * @date 3/25/24
 */
public abstract class Car {
    protected String status = "";

    public abstract void drive(int num, String delimiter);

    public abstract int getNumber();

    public String getStatus() {
        return this.status;
    }
}
