package escaperoom.riddle;

public interface Riddle {
    String inspect();
    boolean solve(String value);
    @Override
    String toString();
}
