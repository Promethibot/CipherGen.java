import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author Promethibot
 * @description Cipher generator for the game "Cobalt", inspired by Librus. Thank you, Librus.
 */
public class CipherGen extends JPanel {

    //Create random elements
    static Random random = new Random();

    /**
     * Create ArrayList of CipherLines that keeps every line you are supposed to draw by keeping the starting point and the ending point.
     */
    static ArrayList<CipherLine> cipherLines = new ArrayList<>();

    /**
     * Stores consonants (and consonant combinations) to be used in name generation.
     */
    static String[] consonants = {"B", "C", "CH", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "QU", "R", "S", "SH", "T", "TH", "V", "W", "X", "Y", "Z"};

    /**
     * Stores vowels to be used in name generation.
     */
    static String[] vowels = {"A", "E", "I", "O", "U"};

    /**
     * Stores possible values for each line to be used in the cipherLines ArrayList.
     */
    static String[] points = {"A", "B", "C", "D", "E", "F"};

    /**
     * Generates the first point using a random member of the points array.
     */
    static String pointA = points[random.nextInt(5)];

    /**
     *  Generates the second point using a random member of the points array.
     */
    static String pointB = points[random.nextInt(5)];

    /**
     * Storage point to hold pointA during the for loop to ensure lines aren't duplicated.
     */
    static String pointC;

    /**
     * Stores the name of the cipher.
     */
    static String name;

    /**
     * Spacing for the drawText in the jar's window.
     */
    int y = 40;

//    static Image image;

//    Toolkit t = Toolkit.getDefaultToolkit();

    /**
     *
     * @param g What to draw on the screen.
     */
    public void paint(Graphics g){
    //    image = t.getImage("CipherBase.png");
        g.drawString(name, 10, 20);

        for (int i = 0; i < cipherLines.size(); ++i) {
            g.drawString(cipherLines.get(i).getPointA() + " to " + cipherLines.get(i).getPointB(), 10, y);
            y = y + 20;
        }

    //    g.drawImage(image, 10, y + 20, this);
    }

    /**
     *
     * @param args None arguments with left "please run my program".
     */
    public static void main (String[] args) throws IOException {

        name = consonants[random.nextInt(23)] + vowels[random.nextInt(4)] + consonants[random.nextInt(23)] + vowels[random.nextInt(4)];
        name = name.substring(0, 4);
        System.out.println(name);

        for (int i = 0; i < (random.nextInt(6 - 4) + 4); ++i) {


            pointB = points[random.nextInt(5)];

            while (pointA.equals(pointB) || pointB.equals(pointC)) {
                pointB = points[random.nextInt(5)];
            }

            cipherLines.add(new CipherLine(pointA, pointB));

            if (cipherLines.size() > 1) {
                for (int y = 0; y < cipherLines.size() - 1; ++y) {
                    if (cipherLines.get(i).getPointA().equals(cipherLines.get(y).getPointB()) && cipherLines.get(i).getPointB().equals(cipherLines.get(y).getPointA()) || cipherLines.get(y).equals(cipherLines.get(i))) {
                       cipherLines.remove(i);
                       break;
                    }
                    continue;
                }
            }

            System.out.println(cipherLines.get(i).getPointA() + " to " + cipherLines.get(i).getPointB());

            pointC = pointA;

            pointA = pointB;


        }

        JFrame frame = new JFrame("CipherGen");
        //Assistance from https://stackoverflow.com/questions/18309868/imageio-iioexception-cant-read-input-file
        BufferedImage cipherBase = ImageIO.read(new File("src/CipherBase.png"));
        JLabel picLabel = new JLabel(new ImageIcon(cipherBase));
        frame.getContentPane().add(new CipherGen());
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //This one needs to be here as well or there will be no text at all
        frame.setVisible(true);
        frame.getContentPane().add(picLabel);
        frame.setVisible(true);
    }

}
