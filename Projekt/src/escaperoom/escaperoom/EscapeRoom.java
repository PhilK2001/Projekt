package escaperoom.escaperoom;

import escaperoom.exceptions.InvalidInputException;
import escaperoom.inout.InOut;
import escaperoom.room.Room;

/**
 * @author Holger Haupt
 * @version 1.0
 */
public class EscapeRoom {
	private Room[] rooms;

	/**
	 * fills room array with instances
	 *
	 * @param amountOfRooms array with length = # of rooms, and each cell dictating
	 *                      the # riddles in that room
	 */
	public EscapeRoom(int[] amountOfRooms) {
		rooms = new Room[amountOfRooms.length];
		for (int i = 0; i < amountOfRooms.length; i++) {
			switch (i) {
			case 0:
				rooms[i] = new Cellar(amountOfRooms[i]);
				break;
			case 1:
				rooms[i] = new Library(amountOfRooms[i]);
				break;
			case 2:
				rooms[i] = new Laboratory(amountOfRooms[i]);
				break;
			default:
				rooms[i] = new Room(amountOfRooms[i]);
			}
		}
	}

	/**
	 * starts game, going from room to room in order of the array, letting player
	 * choose which riddle to do in each room
	 *
	 * @return whether or not all riddles in all rooms have been completed upon exit
	 */
	public boolean play() {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].isSolved()) {
				continue;
			}
			Riddle[] riddles = rooms[i].getRiddles();
			while (!rooms[i].isSolved()) {
				InOut.getInOut().print("Choose:");
				for (int j = 0; j < riddles.length; j++) {
					if (riddles[j].isSolved()) {
						InOut.getInOut().print(" : " + riddles[j].inspect() + " (solved)");
					} else {
						InOut.getInOut().print(j + ": " + riddles[j].inspect());
					}
				}
				try {
					InOut.getInOut().print(riddles.length + ": easy way out");
					int choice = InOut.getInOut().getInteger();
					if (choice == riddles.length) {
						return false;
					} else if (riddles[choice].isSolved()) {
						InOut.getInOut().print("Riddle has been solved already.");
					} else {
						riddles[choice].solve();
					}
				} catch (InvalidInputException | ArrayIndexOutOfBoundsException e) {
					InOut.getInOut().print("Illegal choice. Try again.");
				}
			}
		}
		return true;
	}
}