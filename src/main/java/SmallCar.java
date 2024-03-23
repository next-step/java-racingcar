/**
 * @author jeongheekim
 * @date 3/12/24
 */
public class SmallCar implements Car {
    private String status = "";

    @Override
    public void drive(int num) {
        if (num >= 4) {
            this.status = this.status + "-";
        }
        System.out.println(this.status);
    }

    @Override
    public int getNumber() {
        return (int) (Math.random() * 10);
    }

    public String getStatus() {
        return status;
    }
}

