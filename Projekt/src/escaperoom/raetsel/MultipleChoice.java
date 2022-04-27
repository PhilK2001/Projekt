package escaperoom.raetsel;

import java.util.ArrayList;

import escaperoom.inout.InOut;

public class MultipleChoice {

	// Vars
	private InOut io = InOut.getInOut();
	private ArrayList<String> questions = new ArrayList<>();
	private String[][] possibleAnswers = new String[3][3];

	private int[] correctAnswerPositions = new int[3];

	// Konstr
	public MultipleChoice() {

	}

	// Methods
	public void startRiddle() {
		// Open scanner
		io.startScanner();
		
		//Init Questions, Options, Answers
		this.questions();
		this.addOptions();
		this.initializeAnswerPositions();

		for (int i = 0; i < questions.size(); i++) {
			boolean isFalse = true;
			//Loop until answer is correct
			while (isFalse) {
				io.print(this.printQuestion(i));

				io.print("");

				io.print(this.printOptions(i));

				io.print("Antwort eingeben: ");
				int antwort = Integer.valueOf(io.getText());

				if (antwort == correctAnswerPositions[i]) {
					io.print("Antwort korrekt!");
					isFalse = false;
				} else {
					io.print("Antwort leider falsch");
				}
			}
			io.print("");

		}
		// Close scanner
		io.closeScanner();
	}

	private void questions() {
		this.addQuestion("Was ist 5 + 7?");
		this.addQuestion("Wann endete der 2. Weltkrieg");
		this.addQuestion("Wann ist das nächste Schaltjahr");
	}

	private void addOptionsQuestionOne() {
		this.addOption("12", 0, 0);
		this.addOption("17", 0, 1);
		this.addOption("-4", 0, 2);
	}

	private void addOptionsQuestionTwo() {
		this.addOption("1939", 1, 0);
		this.addOption("1945", 1, 1);
		this.addOption("1967", 1, 2);
	}

	private void addOptionsQuestionThree() {
		this.addOption("2022", 2, 0);
		this.addOption("2024", 2, 1);
		this.addOption("2023", 2, 2);
	}

	private void addOptions() {
		this.addOptionsQuestionOne();
		this.addOptionsQuestionTwo();
		this.addOptionsQuestionThree();
	}

	private String printOptions(int index) {
		String output = "";
		if (index < possibleAnswers.length) {
			int x = 1;
			for (int n = 0; n < possibleAnswers[index].length; n++) {
				output += "   " + x++ + " " + possibleAnswers[index][n];
				output += "\n";
			}
		}

		return output;
	}

	private void addQuestion(String question) {
		this.questions.add(question);
	}

	private String printQuestion(int pos) {
		return this.questions.get(pos);
	}

	private void addOption(String answer, int posQuestion, int posAnswer) {
		this.possibleAnswers[posQuestion][posAnswer] = answer;
	}

	private void addCorrectAnswersPosition(int index, int answer) {
		this.correctAnswerPositions[index] = answer;
	}
	
	private void initializeAnswerPositions() {
		this.addCorrectAnswersPosition(0, 1);
		this.addCorrectAnswersPosition(1, 2);
		this.addCorrectAnswersPosition(2, 2);
	}
	
}
