package africa.semicolon.wollet.execption;

public class mailAlreadyExistException extends RuntimeException {
    public mailAlreadyExistException(String message) {
        super(message);
    }
}
