package escaperoom.room;

import escaperoom.riddle.Riddle;

/**
 * @author Holger Haupt
 * @version 0.1
 */
public class Room {
    protected Riddle[] riddles;

    public Room(int amountOfRiddles) {
        riddles = new Riddle[amountOfRiddles];
        //TODO instance random riddles
    }

    /**
     * determines the solved state of the room by looking at all riddles
     *
     * @return whether or not all riddles in this room are solved
     */
    public boolean isSolved() {
        boolean solved = true;
        for (Riddle riddle : riddles) {
            solved &= riddle.isSolved();
        }
        return solved;
    }

    /**
     * getter for the riddles array
     *
     * @return all riddles in this room
     */
    public Riddle[] getRiddles() {
        return riddles;
    }
}