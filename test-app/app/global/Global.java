package global;
import play.Application;
import play.GlobalSettings;
import play.Play;
import play.libs.F;

import com.stys.platform.pages.Service;
import com.stys.platform.pages.impl.Page;
import com.stys.platform.pages.impl.edit.EditPlugin;
import com.stys.platform.pages.impl.models.Revision;
import com.stys.platform.pages.impl.utils.ContentResult;

/**
 *
 */
public class Global extends GlobalSettings {

	private static final F.Option<Long> None = new F.None<Long>(); 
	
    @Override
    public void onStart(Application application) {

        if (0 == Revision.find.findRowCount()) {
       	
        	// Get page service (edit)
        	Service<ContentResult, Page> service = Play.application().plugin(EditPlugin.class).getPagesService();
        	
        	// Test page 1
            Page alice = new Page();
            alice.namespace = "alice";
            alice.key = "down-the-rabbit-hole";
            alice.status = com.stys.platform.pages.impl.Page.PUBLISHED;
            alice.template = "a";
            alice.title = "Alice in Wonderland";
            alice.source = 
            	"# Alice's Adventures in Wonderland\n "
            	+ "### CHAPTER I. Down the Rabbit-Hole\n"
            	+ "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, 'and what is the use of a book,' thought Alice 'without pictures or conversations?' ";
              
            // Store test page 1
            service.put(alice, alice.namespace, alice.key, None);
            
            // Test page 2
            Page bob = new Page();
            bob.namespace = "bob_marley";
            bob.key = "home";
            bob.template = "b";
            bob.title = "Bob Marley";
            bob.source = 
            	"# Bob Marley\n" 
            	+ "### From Wikipedia, the free encyclopedia\n" 
            	+ "**Robert Nesta \"Bob\" Marley** OM (6 February 1945 – 11 May 1981) was a Jamaican reggae singer-songwriter, musician, and guitarist who achieved international fame and acclaim.";
        
            // Store test page 2
            service.put(bob,  bob.namespace, bob.key, None);
        }

    }

}