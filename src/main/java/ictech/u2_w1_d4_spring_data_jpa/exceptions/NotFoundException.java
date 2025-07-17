package ictech.u2_w1_d4_spring_data_jpa.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("ID '" + id + "' was not found.");
    }
}
