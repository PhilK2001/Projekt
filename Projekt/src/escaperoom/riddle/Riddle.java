package escaperoom.riddle;

/**
 * @author Holger Haupt
 * @version 1.0
 */
public interface Riddle {
    /**
     * @return short overview of the riddle (approximately one line)
     */
    String inspect();

    /**
     * contains logic for solving the riddle
     */
    void solve();

    @Override
    String toString();

    /**
     *
     * @return the solved state of the riddle
     */
    boolean isSolved();
}