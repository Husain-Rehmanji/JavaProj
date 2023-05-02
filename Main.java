import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
class ABC extends JFrame
{
    private JLabel heading;
    private JLabel clockLable;
    private Font font = new Font("Comic Sans MS", Font.BOLD, 35);

    ABC()
    {
        super.setTitle("My Clock");
        super.setSize(400, 400);
        super.setLocation(300, 50);
        this.Design();
        theClock();
        super.setVisible(true);
    }

    public void Design()
    {
        heading = new JLabel("Proj1");
        clockLable = new JLabel("Clock");
        heading.setFont(font);
        clockLable.setFont(font);
        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLable);
    }

    public void theClock()
    {
        // java.util.Timer timer = new java.util.Timer(1000L, new ActionListener()
        // {
        //     @Override
        //     public void actionPerformed(ActionEvent e)
        //     {
        //         String dateTime=new Date().toString();
        //         clockLable.setText(dateTime);
        //     }
        // });
        // timer.start();

        Thread th = new Thread(){
            public void run()
            {
                try
                {
                    while(true)
                    {
                        String dateTime=new Date().toString();
                        clockLable.setText(dateTime);
                        Thread.currentThread().sleep(1000);
                    }
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        th.start();
    }
}

public class Main
{
    public static void main(String args[])
    {
        ABC w = new ABC();
    }
}