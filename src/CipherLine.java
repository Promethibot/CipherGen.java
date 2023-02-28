/**
 * @author Promethibot
 * Class to be used for the ArrayList in @see CipherGen.java.
 */
public class CipherLine {
    /**
     * Starting point of line.
     */
    protected String pointA;

    /**
     * Ending point of line.
     */
    protected String pointB;

    /**
     *
     * @param pointA The starting point of the line.
     * @param pointB The ending point of the line.
     */
    public CipherLine(String pointA, String pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    /**
     *
     * @return Returns the beginning point of the line.
     */
    public String getPointA() {
        return pointA;
    }

    /**
     *
     * @return Returns the finishing point of the line.
     */
    public String getPointB() {
        return pointB;
    }

}
