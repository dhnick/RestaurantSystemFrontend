package za.ac.cput.gui.Tim.Waiter;

import za.ac.cput.domain.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class FindAllWaitersGUI implements ActionListener {

    //Initializing Components
    private JFrame GetAllFrame;
    private JPanel GetAllPanelNorth, GetAllPanelEast, GetAllPanelWest, GetAllPanelSouth, GetAllPanelCenter;
    private JTextArea WaiterTextArea;
    private JLabel lblHeading;
    private JButton btnFindAll, btnClear, btnReturn;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont, textAreaFont;
    private JScrollPane scrollPane;



    public FindAllWaitersGUI(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        GetAllFrame = new JFrame("Customer");

        //Panels
        GetAllPanelSouth = new JPanel();
        GetAllPanelNorth = new JPanel();
        GetAllPanelNorth.setBackground(Color.LIGHT_GRAY);
        GetAllPanelCenter = new JPanel();
        GetAllPanelCenter.setBackground(Color.LIGHT_GRAY);

        //TextArea
        WaiterTextArea = new JTextArea(50, 40);
        WaiterTextArea.setBackground(Color.white);
        WaiterTextArea.setLineWrap(true);
        WaiterTextArea.setWrapStyleWord(true);


        //Fillers:
        Filler1 = new JLabel("===========");
        Filler2 = new JLabel("===========");
        Filler3 = new JLabel("================================");
        Filler4 = new JLabel("================================");
        Filler5 = new JLabel("================================");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("View All Customers",JLabel.CENTER);

        //Buttons
        btnFindAll = new JButton("View All Customers");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }



    //Setting GUI Layout
    public void setGUI() {
        GetAllPanelNorth.setLayout(new GridLayout(3, 1));

        //Adding the components to the panels:
        //Panel North:
        GetAllPanelNorth.add(Filler5);
        GetAllPanelNorth.add(lblHeading);
        GetAllPanelNorth.add(btnFindAll);

        //Panel Center
        GetAllPanelCenter.add(WaiterTextArea);

        //Panel South
        GetAllPanelSouth.add(btnClear);
        GetAllPanelSouth.add(btnReturn);

        //Adding panels to Waiter Frame:
        GetAllFrame.add(GetAllPanelSouth, BorderLayout.SOUTH);
        GetAllFrame.add(GetAllPanelNorth, BorderLayout.NORTH);
        GetAllFrame.add(GetAllPanelCenter, BorderLayout.CENTER);

        //Telling compiler to listen for actions from the buttons:
        btnReturn.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        GetAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GetAllFrame.pack();
        GetAllFrame.setSize(400, 500);
        GetAllFrame.setLocationRelativeTo(null);
        GetAllFrame.setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //When Display all button is clicked
        if(e.getActionCommand().equals("View All Customers")){

            Httpsmethods httpsmethods = new Httpsmethods();

            //Create set to store method output
            Set<Waiter> waiters = httpsmethods.getWaiters(); // change backend

            //Display set in text area
            WaiterTextArea.setText(String.valueOf(waiters));
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            WaiterTextArea.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            GetAllFrame.dispose();
        }


    }
}
