package escaperoom.inout;

import escaperoom.exceptions.InvalidInputException;

import java.util.Scanner;

public class InOut {
	private Scanner sc;
	private static InOut inout;

	public static InOut getInOut() {
		if (inout == null) {
			inout = new InOut();
		}
		return inout;
	}

	private InOut() {
	}

	public void startScanner() {
		sc = new Scanner(System.in);
	}

	public void closeScanner() {
		sc.close();
	}

	public void print(String toPrint) {
		System.out.println(toPrint);
	}
	
	public void printSameLine(String toPrint) {
		System.out.print(toPrint);
	}

	public String getText() {
		return sc.next();
	}

	public String getText(String toPrint) {
		print(toPrint);
		return getText();
	}

	public String getTextFitting(String regex) throws InvalidInputException {
		String input = getText();
		if (!input.matches(regex)) {
			throw new InvalidInputException();
		}
		return input;
	}

	public int getInteger() throws InvalidInputException {
		return Integer.parseInt(getTextFitting("-?[0-9]+"));
	}
}
