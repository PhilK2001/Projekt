package escaperoom.test;

import escaperoom.exceptions.InvalidInputException;
import escaperoom.inout.InOut;

public class InOutTest {
	public static void main(String[] args) {
		InOut inout = InOut.getInOut();
		inout.startScanner();

		System.out.println("TestInput: \"Test Test\"");
		inout.print("Test Test");

		System.out.println(inout.getText());

		System.out.println("TestInput: \"Test Test\"");
		System.out.println(inout.getText("Test Test"));

		try {
			System.out.println("TestInput: \"zeit\"");
			System.out.println(inout.getTextFitting("zeit"));
		} catch (InvalidInputException e) {
			System.out.println("Exception thrown");
		}

		try {
			System.out.println(inout.getInteger());
		} catch (NumberFormatException e) {
			System.out.println("Formatting Failed");
		} catch (InvalidInputException e) {
			System.out.println("Exception thrown");
		}

		inout.closeScanner();
	}
}
