package exception;

public class LoadTimeException extends Exception {
	public String getErrorMessage() {
		return "Can't pick when your hand is reloading.";
	}
}
