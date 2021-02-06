import javax.swing.*;
public class Game extends JFrame 
{
    ButtonPanel panel;
    public Game()
    {
        panel = new ButtonPanel();
        add(panel);
        setSize(400,200);
        setVisible(true);
        panel.sequence();
    }
    public static void main ( String [] args) 
    {
        Game game = new Game();
        try
        {
            Thread.sleep(10);
        }

        catch (Exception e)
        {
            System.out.println("Exception e is occured: " + e);
        }
        
        

    }
}
