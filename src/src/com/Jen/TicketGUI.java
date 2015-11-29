package src.com.Jen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Date;

/**
 * Created by Jen Mart on 11/7/2015.
 */
public class TicketGUI extends JFrame{
    private JTextField reporterTextField;
    private JTextField priorityTextField;
    private JTextField issuesTextField;
    private JList ticketJList; //*************
    private JPanel rootPanel;
    private JButton submitButton;
    private JButton resolvedButton;
    private JTextField resolvedTextField;
    static DefaultListModel<String> ticketListModel;
    DefaultListModel<String> arl;


    public TicketGUI() throws FileNotFoundException, UnsupportedEncodingException {
        super("Ticket list");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ReadWrite readWrite = new ReadWrite();
        BufferedReader reader = new BufferedReader(new FileReader("reports.txt"));
        readWrite.TextRead();
        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("reports.txt", true), "UTF-8"));
        ticketListModel = new DefaultListModel<String>();
        ticketJList.setModel(ticketListModel);//*************
        ticketJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//*************
        int count = ticketListModel.size();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reporter = reporterTextField.getText();
                String issue = issuesTextField.getText();
                String priorityAsString = priorityTextField.getText();
                int priority;
                try {
                    priority = Integer.parseInt(priorityAsString);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(TicketGUI.this, "Enter a positive number");
                    return;
                }
                //String desc, int p, String rep, Date dateRep
                Date dateReported = new Date();
                Ticket newTicket = new Ticket(issue, priority, reporter, dateReported, false);
//                TicketGUI.this.ticketListModel.addElement(newTicket);
                TicketGUI.this.ticketListModel.addElement(newTicket.toString());

            }
        });

        resolvedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date resolveDate = new Date();
                String resolveReason = resolvedTextField.getText();
                Ticket saveTicket = (Ticket) TicketGUI.this.ticketJList.getSelectedValue();//*************
                String ticketDate = saveTicket + " Resolved on date: "+ resolveDate + "Resolved reason: " + resolveReason;
//                TicketGUI.this.arl.addElement(saveTicket);
//                TicketGUI.this.arl.removeElement(saveTicket);
//                writer.println(saveTicket + " Resolved on date: "+ resolveDate + "Resolved reason: " + resolveReason);
//                try(PrintWriter output = new PrintWriter(new FileWriter("reports.txt",true)))
//                {
//                    output.printf("%s\r\n",ticketDate);
//                }
//                catch (Exception ec) {

//                }



//                try {
//                    Files.write(Paths.get("reports.txt"),ticketDate.getBytes(), StandardOpenOption.APPEND);
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
            }
        });
    }
}
