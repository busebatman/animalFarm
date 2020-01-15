//If user tries to add an animal with the same name, program will given an exception
public class IllegalNameException extends Exception {
	public IllegalNameException() {
		super();
	}

	public IllegalNameException(String message) {
		System.out.println(message);
	}
}

