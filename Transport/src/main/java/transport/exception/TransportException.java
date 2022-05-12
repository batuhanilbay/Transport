package transport.exception;



public class TransportException extends RuntimeException{

	
	private String message;

	public TransportException(String message) {
		this.message = message;
	}
	
}