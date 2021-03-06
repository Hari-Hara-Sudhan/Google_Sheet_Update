//working code to display the google sheet info without authentication
package Read_Wauth;

import java.io.IOException;

import java.net.URL;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.util.ServiceException;

public class PrintSpreadsheet {
    public static void main(String[] args) {
        SpreadsheetService service = new SpreadsheetService("Sheet1");
        try {
            String sheetUrl =
                "https://spreadsheets.google.com/feeds/list/1BuEN5wHRrQJFgTj9bXN6lXEAcb1lcJ-QYg4Lya-3lCo/default/public/values";
            
            URL url = new URL(sheetUrl);

            // Get Feed of Spreadsheet url
            ListFeed lf = service.getFeed(url, ListFeed.class);

            
            
            //Iterate over feed to get cell value
            for (ListEntry le : lf.getEntries()) {
                CustomElementCollection cec = le.getCustomElements();
                //Pass column name to access it's cell values
                String val = cec.getValue("CustomerName");
                System.out.println(val);
                String val2 = cec.getValue("Customeremailid");
                System.out.println(val2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}