import com.google.gdata.client.authn.oauth.*;
import com.google.api.client.auth.oauth2.Credential;
import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.*;
import com.google.gdata.data.batch.*;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;
//import org.springframework.social.oauth2.*;
import org.glassfish.jersey.client.oauth2.*;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class MySpreadsheetIntegration {
  public static void main(String[] args)
      throws AuthenticationException, MalformedURLException, IOException, ServiceException {

	  SpreadsheetService service =
        new SpreadsheetService("MySpreadsheetIntegration-v1");
	  service.setProtocolVersion(SpreadsheetService.Versions.V3);

    // TODO: Authorize the service object for a specific user (see other sections)

	  final String CLIENT_ID = "748106676844-3p9ssahs0hk914bf8mecep65gq53rghv.apps.googleusercontent.com";
	  final String CLIENT_SECRET = "KSI78ZQ9ooYMX9YMu-HnW3aA";
	  final String SCOPE = "https://spreadsheets.google.com/feeds https://docs.google.com/feeds";
	  
	  OAuth2Parameters parameters = new OAuth2Parameters();
	  parameters. = CLIENT_ID;
	  
	  
	  
    // Define the URL to request.  This should never change.
    URL SPREADSHEET_FEED_URL = new URL(
        "https://spreadsheets.google.com/feeds/spreadsheets/private/full");

    // Make a request to the API and get all spreadsheets.
    SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL,
        SpreadsheetFeed.class);
    List<SpreadsheetEntry> spreadsheets = feed.getEntries();

    if (spreadsheets.size() == 0) {
      // TODO: There were no spreadsheets, act accordingly.
    }
    
    ListFeed lf = service.getFeed(SPREADSHEET_FEED_URL, ListFeed.class);
    
 
    
    for (ListEntry row : lf.getEntries()) {
    	row.getCustomElements().setValueLocal("CustomerId",row.getId());
    	row.update();
    }
    }
 }