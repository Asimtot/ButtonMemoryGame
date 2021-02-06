import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ButtonPanel extends JPanel {
    // Instance variables
    private final int DEFAULT_SPEED = 500; // I write to speed respect to milisecond
    private final int FIRST_LEVEL = 1; // First Level of the game
    private int difficulty;
    private int moveOrder;

    private boolean isFinished;
    private boolean isLevelFinished;

    private ArrayList<Integer> orderList;

    // Buttons
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton settingButton;

    private int level;

    private JLabel label;
    private JSlider slider;

    private JPanel west;
    private JPanel east;
    private JPanel topPanel;
    private JPanel bottomPanel;

    public ButtonPanel() {
        // Difficulty of the game
        difficulty = DEFAULT_SPEED;

        isFinished = false;
        isLevelFinished = false;

        // Move Order
        moveOrder = 0;

        // All the panels which hold components
        west = new JPanel();
        east = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();

        // Buttons which will click
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        level = FIRST_LEVEL; // every game will start f level 1

        orderList = new ArrayList<>();

        setLayout(new GridLayout(1, 2)); // Setting the layout for buttons
        west.setLayout(new GridLayout(3, 3));
        east.setLayout(new GridLayout(2, 1));

        // First Row Buttons WEST PANEL
        west.add(button1);
        west.add(button2);
        west.add(button3);

        // Second Row Buttons WEST PANEL
        west.add(button4);
        west.add(button5);
        west.add(button6);

        // Third Row Buttons WEST PANEL
        west.add(button7);
        west.add(button8);
        west.add(button9);

        // Top Panel Settings
        label = new JLabel();
        label.setText("Level is " + level);
        topPanel.add(label);

        // BottomPanel
        slider = new JSlider();
        settingButton = new JButton("Settings");
        bottomPanel.add(slider);
        bottomPanel.add(settingButton);

        // EAST Panel
        east.add(topPanel);
        east.add(bottomPanel);

        add(west);
        add(east);

    }

    /**
     * Getting the level of the
     * 
     * @author Efe Can Tepe
     * @version 02.05.2021
     * @return
     */
    public int getLevel() {
        return level;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * This method will return between 1 and 9 inclusive
     * 
     * @author Efe Can Tepe
     * @return
     */
    public int randomOrderCreate() 
    {
        int random = (int) ((Math.random() * 9) + 1);
        System.out.println(random);

        return random;
    }

    /**
     * This method will add the button order
     * 
     * @author Efe Can Tepe
     * @version 02.05.2021
     */
    public void addNumberToList() 
    {
        for (int a = 0; a < level; a++) 
        {
            orderList.add(randomOrderCreate());
        }
    }

    /**
     * This method will reset the list and move order at the new game
     * 
     * @author Efe Can Tepe
     * @version 02.05.2021
     */
    public void restList() {
        for (int a = orderList.size(); a >= 0; a--) {
            orderList.remove(a);
        }

        // setting the start of the game 0 for new level
        moveOrder = 0;
    }

    public void displayColor() 
    {
        for (int i = 0; i < orderList.size(); i++) 
        {
            System.out.println(" i = " + i + " Order Number is: " +orderList.get(i));
            if (orderList.get(i) == 1) {
                button1.setBackground(Color.BLUE);
            }

            else if (orderList.get(i) == 2) {
                button2.setBackground(Color.BLUE);
            }

            else if (orderList.get(i) == 3) {
                button3.setBackground(Color.BLUE);
            }

            else if (orderList.get(i) == 4) {
                button4.setBackground(Color.BLUE);
            }

            else if (orderList.get(i) == 5) {
                button5.setBackground(Color.BLUE);
            }

            else if (orderList.get(i) == 6) {
                button6.setBackground(Color.BLUE);
            }

            else if (orderList.get(i) == 7) {
                button7.setBackground(Color.BLUE);
            }

            else if (orderList.get(i) == 8) {
                button8.setBackground(Color.BLUE);
            }

            else if (orderList.get(i) == 9) {
                button9.setBackground(Color.BLUE);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            button1.setBackground(null);
            button2.setBackground(null);
            button3.setBackground(null);
            button4.setBackground(null);
            button5.setBackground(null);
            button6.setBackground(null);
            button7.setBackground(null);
            button8.setBackground(null);
            button9.setBackground(null);
        }
    }
    
    public void sequence()
    {
        while(!isFinished)
        {
            addNumberToList();
            displayColor();
        }
    }
}
