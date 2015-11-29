package src.com.Jen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jen Mart on 11/28/2015.
 */
public class ReadWrite extends FileNotFoundException {
    static String line = null;
    public static void TextRead(){
                try {
            BufferedReader reader = new BufferedReader(new FileReader("reports.txt"));
            while ((line = reader.readLine()) != null){
//                System.out.println(line);
//                TicketGUI.ticketListModel.addElement(line.split(";").toString());
                String[] ticket = line.split(";");

//                TicketGUI.ticketListModel.addElement(tick.toString());

            }
        }catch (IOException e){

        }
    }
    //        while ((line = reader.readLine()) != null) { //while-loop to pick apart file and store in three array lists.
////            String[] parts = line.split(";"); //Split each like on semi-colon
////            drinks.add(parts[0]);
////            makeCost.add(Double.parseDouble(parts[1]));
////            sellCost.add(Double.parseDouble(parts[2]));
//            return line;
//        }
}
