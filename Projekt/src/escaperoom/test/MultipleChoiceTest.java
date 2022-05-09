package escaperoom.test;

import escaperoom.inout.InOut;
import escaperoom.raetsel.MultipleChoice;

public class MultipleChoiceTest {

	private static InOut io = InOut.getInOut();

	public static void main(String[] args) {
		io.startScanner();
		final int amountPossibleAnswers = 3;
		String[] possibleAnswersOne = new String[amountPossibleAnswers];
		String[] possibleAnswersTwo = new String[amountPossibleAnswers];
		String[] possibleAnswersThree = new String[amountPossibleAnswers];
		
		// Question One
		String questionOne = "Was bedeutet * beim import?";
		possibleAnswersOne[0] = "Import aller Klassen und Unterpakete";
		possibleAnswersOne[1] = "Import aller Unterpakete, jedoch ohne Unterklassen";
		possibleAnswersOne[2] = "Import aller Klassen, jedoch ohne Unterpakete";
		int answerOne = 3;
		
		//Question Two
		String questionTwo = "Wozu dient der finally Block?";
		possibleAnswersTwo[0] = "Für Anweisungen, die immer ausgeführt werden sollen";
		possibleAnswersTwo[1] = "In diesen Block werden die Exceptions abgefangen";
		possibleAnswersTwo[2] = "Kennzeichnung, dass die Methode fertig ist.";
		int answerTwo = 1;
		
		//Question Three
		String questionThree = "Was für eine Beziehung beschreibt die Vererbung?";
		possibleAnswersThree[0] = "... besteht aus ...";
		possibleAnswersThree[1] = "... ist ein...";
		possibleAnswersThree[2] = "... ist abhängig von ...";
		int answerThree = 2;
		
		MultipleChoice mc = new MultipleChoice(questionOne, possibleAnswersOne, answerOne);
		io.print(mc.inspect());
//		io.print(mc.toString());
		io.print("Korrekte Antwort: 3" );
		mc.solve();
		io.print(String.valueOf(mc.isSolved()));
		io.print("");

		MultipleChoice mc2 = new MultipleChoice(questionTwo, possibleAnswersTwo, answerTwo);
//		io.print(mc2.toString());
		io.print("Korrekte Antwort: 1" );
		mc2.solve();
		io.print(String.valueOf(mc2.isSolved()));
		io.print("");
		
		MultipleChoice mc3 = new MultipleChoice(questionThree, possibleAnswersThree, answerThree);
//		io.print(mc3.toString());
		io.print("Korrekte Antwort: 2" );
		mc3.solve();
		io.print(String.valueOf(mc3.isSolved()));
		io.closeScanner();
	}
}