package escaperoom.raetsel;

import escaperoom.exceptions.InvalidInputException;
import escaperoom.inout.InOut;
import escaperoom.riddle.Riddle;

/**
 * 
 * @author Philip Keidel
 * @version 1.0
 */
public class MultipleChoice implements Riddle {

	// Vars
	private InOut io = InOut.getInOut();
	private String question;
	private String[] possibleAnswers;
	//CorrectAnswer String Array
	//FalseAnswer 2dim String Array
	//Question String Array
	private int expectedAnswer;
	private String introduction;
	private boolean solved = false;
	private String output = "";

	// Constructors
	public MultipleChoice(String question, String[] possibleAnswers, int expectedAnswer) {
		this.question = question;
		this.possibleAnswers = possibleAnswers;
		this.expectedAnswer = expectedAnswer;
	}

	// Methods
	@Override
	public String toString() {
		String output = "";
		int i = 1;
		output += question + "\n";
		for (String s : possibleAnswers) {
			output += "   " + i + " " + s + "\n";
			i++;
		}
		return output;
	}

	@Override
	public String inspect() {
		this.introduction = "Angekommen in der Bücherrei findest du ein Buch mit Programmierfragen. "
				+ "Diese Fragen decken den aktuellen Stoff der Prog2-Vorlesungen und eignen sich somit optimal"
				+ "zur Klausurvorbereitung. \nDu versuchst daher folgende Multiple Choice-Fragen zu lösen";
		this.introduction += "\n";
		return introduction;
	}

	@Override
	public void solve() {
		boolean loop = true;
		int i = 1;
		this.output += question + "\n";
		for (String s : possibleAnswers) {
			this.output += "   " + i + " " + s + "\n";
			i++;
		}
		System.out.println(this.output);

		while (loop) {
			this.io.printSameLine("Antwort: ");
			int actualAnswer;
			try {
				actualAnswer = io.getInteger();
				if (actualAnswer == expectedAnswer) {
					this.io.print("Antwort korrekt!");
					this.solved = true;
					loop = false;
				} else {
					this.io.print("Antwort leider falsch");
				}
			} catch (InvalidInputException e) {
				io.print("Fehlerhafte Eingabe. Bitte Zahl der Antwort eingeben");
			}
			
		}
		
	}
	
	@Override
	public boolean isSolved() {
		return this.solved;
	}

}
