package africa.semicolon.wollet.execption;

public class WalletNotFoundExepction extends RuntimeException {
    public WalletNotFoundExepction(String message) {
        super(message);
    }
}
