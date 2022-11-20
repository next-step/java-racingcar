package laststep.service;

public interface ExceptionTemplate {
    default Object confirm() {
        while (true) {
            try {
                return check();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    Object check();
}
