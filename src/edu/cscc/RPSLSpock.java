package edu.cscc;
import java.util.Random;

/**
 * Class drives core features of game including moves that are valid, picking, and determining winner.
 *
 * @author Dustin Buschman
 */
public class RPSLSpock {

    static Random rand = new Random(System.currentTimeMillis());

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    public static final String LIZARD = "lizard";
    public static final String SPOCK = "spock";


    /**
     * Method takes the users pick and compares it to the available/valid picks. If the pick is valid,
     * then the method returns true, otherwise, it is false.
     *
     * @param  pick  A String containing the users choice from a set of 5 possible choices
     * @return       The validity of the pick
     */
    public static boolean isValidPick(String pick) {
        if (pick == null) {
            return false;
        }
        pick = pick.trim();
        return (ROCK.equalsIgnoreCase(pick) ||
                PAPER.equalsIgnoreCase(pick) ||
                SCISSORS.equalsIgnoreCase(pick) ||
                LIZARD.equalsIgnoreCase(pick) ||
                SPOCK.equalsIgnoreCase(pick));
    }

    /**
     * Method generates a random number (1-5) using the Math.util.Random library
     * and then returns the corresponding pick.
     *
     * @return A String containing the corresponding pick.
     */
    public static String generatePick() {
        String pick = null;
        switch (rand.nextInt(5)) {
            case 0:
                pick = ROCK;
                break;
            case 1:
                pick = PAPER;
                break;
            case 2:
                pick = SCISSORS;
                break;
            case 3:
                pick = LIZARD;
                break;
            case 4:
                pick = SPOCK;
                break;
        }
        return pick;
    }

    /**
     * After user and computer make picks, this method determines what combinations of picks
     * that make the computer win. If the computer wins the method returns true. Otherwise, the
     * method returns false.
     *
     * @param c_pick the computers pick
     * @param h_pick the users pick
     * @return       boolean indicating if the computer has won
     */
    public static boolean isComputerWin(String c_pick,String h_pick) {
        h_pick = h_pick.toLowerCase();
        return ((ROCK.equals(c_pick) && (SCISSORS.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (PAPER.equals(c_pick) && (ROCK.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SCISSORS.equals(c_pick) && (PAPER.equals(h_pick) || LIZARD.equals(h_pick))) ||
                (LIZARD.equals(c_pick) && (PAPER.equals(h_pick) || SPOCK.equals(h_pick))) ||
                (SPOCK.equals(c_pick) && (ROCK.equals(h_pick) || SCISSORS.equals(h_pick))));
    }
}