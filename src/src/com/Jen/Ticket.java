package src.com.Jen;

import java.util.ArrayList;
import java.util.Date;

public class Ticket extends TicketManager{
    private int priority;
    private String reporter; //Stores person or department who reported issue
    private String description;
    private Date dateReported;
    private String resolution;
    private Date dateResolved;

    public static String getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(String ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    private static String ticketInfo;
    ArrayList<String> reports = new ArrayList<>();

//    ArrayList<String> reports = new ArrayList<String>();
//    private BufferedReader reader = new BufferedReader(new FileReader("reports.txt"));


    static String line = null;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //    PrintWriter writer = new PrintWriter("reports.txt");
  private boolean status = false;
//If any Ticket object modifies this counter, all Ticket objects will have the modified value
//Make it private - only Ticket objects should have access
    protected static int staticTicketIDCounter = 1;
    //The ID for each ticket - instance variable. Each Ticket will have it's own ticketID variable
    protected int ticketID;



    public void setDateResolved(Date dateResolved) {
        this.dateResolved = dateResolved;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setStaticCounter(int num){
        this.staticTicketIDCounter = num;
    }

    // constructor
    public Ticket(String desc, int p, String rep, Date dateRep, boolean status) {
        this.description = desc;
        this.priority = p;
        this.reporter = rep;
        this.dateReported = dateRep;
        this.status = status;
        this.ticketID = staticTicketIDCounter;
        staticTicketIDCounter++;
    }

    public Ticket(int ID, String descr, int prior, String report, String stat, String reso) {
        this.ticketID = ID;
        this.description = descr;
        this.priority = prior;
        this.reporter = report;
        this.dateReported = new Date();  // TODO make date import from OpenTkts file work
        this.status = status;
        this.dateResolved = new Date();  // TODO make date import from OpenTkts file work
        this.resolution = reso;
    }
//    public String toString(){
//        if(true){
//            return("Things and stuff");
//        }else {
//            return ("Things and stuff");
//        }
//    }

    public Date getDateReported() { return dateReported; }

    public String getResolution() { return resolution; }

    public Date getDateResolved() { return dateResolved; }

    public String getReporter() { return reporter; }

    public int getTicketID() {
        return ticketID;
    }

    public String getDescription() {
        return description;
    }

    protected int getPriority() {
        return priority;
    }

//    public static void TextRead(){
//                try {
//            BufferedReader reader = new BufferedReader(new FileReader("reports.txt"));
//            while ((line = reader.readLine()) != null){
////                System.out.println(line);
//                TicketGUI.ticketListModel.addElement(line);
//            }
//        }catch (IOException e){
//
//        }
//    }

    public String toString() {

//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("reports.txt"));
//            while ((line = reader.readLine()) != null){
////                System.out.println(line);
//                reports.add(line + '\n');
//            }
//        }catch (IOException e){
//
//        }
//

//        return reports.toString();
        String addon = "";
        if (status){

            addon = " Date Resolved: " + this.getDateResolved() + " Resolution: " + this.getResolution();
        }
        ticketInfo = ("ID: " + this.ticketID + " Issued: " + this.description + " Priority: " + this.priority +
                " Reported by: " + this.reporter + " Reported on: " + this.dateReported) + " Status: " + this.isStatus() + addon + ";";

        return ticketInfo;


//        try {
//            for (String line : Files.readAllLines(Paths.get("reports.txt")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        while ((line = reader.readLine()) != null) { //while-loop to pick apart file and store in three array lists.
////            String[] parts = line.split(";"); //Split each like on semi-colon
////            drinks.add(parts[0]);
////            makeCost.add(Double.parseDouble(parts[1]));
////            sellCost.add(Double.parseDouble(parts[2]));
//            return line;
//        }
//        return "end";
    }


}