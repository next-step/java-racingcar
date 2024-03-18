/**
 * @author jeongheekim
 * @date 3/12/24
 */
public class SmallCar implements Car {
    private String status = "";

    @Override
    public void drive() {
        this.status = this.status + "-";
        System.out.println(this.status);
    }

    public String getStatus() {
        return status;
    }
}
