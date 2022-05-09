package escaperoom.game;

import escaperoom.escaperoom.EscapeRoom;
import escaperoom.exceptions.InvalidInputException;
import escaperoom.inout.InOut;

/**
 * @author Alexander Pickelberger
 * @version 1.0
 */
public class Game {
    public static final int MAX_ROOMS = 3;
    protected InOut inOut;

    /**
     * contains the logik to create a EscapeRoom objekt
     * checks if every riddle in EscapeRoom is solved
     */
    public Game() {
        getInOut();
        inOut.startScanner();
        int rooms = initializeRooms();
        int[] amountOfRooms = initializeRiddlesOfRooms(rooms);
        EscapeRoom eRoom = new EscapeRoom(amountOfRooms);
        isSolved(eRoom);
        inOut.closeScanner();
    }

    /**
     * gets an InOut objekt
     */
    public void getInOut() {
        inOut = InOut.getInOut();   //Ein InOut Objekt erzeugen
    }

    /**
     * gets the amount of rooms the player wants
     * @return the amount of rooms
     */
    public int initializeRooms() {
        boolean isValid = false;
        int rooms = 0;
        do {    //How many Rooms he wants to be there
            inOut.print("How many rooms do you want to have?");
            try {
                rooms = inOut.getInteger();
                if (rooms > MAX_ROOMS) {
                    isValid = false;
                    inOut.print("(Maximum: " + MAX_ROOMS + ")");
                }else if(rooms < 1){
                    inOut.print("(Minimum: 1)");
                }else
                    isValid = true;
            } catch (InvalidInputException e) {
                inOut.print("Please only enter a number");
                isValid = false;
            }
        } while (!isValid);
        return rooms;
    }

    /**
     * gets the amount of riddles for every room
     * @param rooms is the amount of rooms (earlyer initialized)
     * @return an array (every slot is a room) and the int in every slot is the amount of riddles for that room
     */
    public int[] initializeRiddlesOfRooms(int rooms) {
        int[] amountOfRooms;
        amountOfRooms = new int[rooms];
        boolean isValid;
        int riddlesForOneRoom;
        for (int i = 0; i < amountOfRooms.length; i++) {
            inOut.print("How many riddles for room: " + (i + 1));
            isValid = false;
            do {     //How many riddles for one room
                try {
                    riddlesForOneRoom = inOut.getInteger();
                    isValid = true;
                    amountOfRooms[i] = riddlesForOneRoom;
                } catch (InvalidInputException e) {
                    inOut.print("Please only enter a number");
                    isValid = false;
                }
            } while (!isValid);
        }
        return amountOfRooms;
    }

    /**
     * simple Methode to check if the game is over
     * @param eRoom is the EscapeRoom objekt
     */
    public void isSolved(EscapeRoom eRoom) {
        if (eRoom.play() == true)
            inOut.print("solved");
        else
            inOut.print("unsolved");
    }

}