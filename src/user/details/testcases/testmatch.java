package user.details.testcases;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import user.details.matchuser;

public class testmatch {

	HashMap<String, Integer> hmap,h1map = new HashMap<String, Integer>();

	@Test
	public void testMatch() 
    {
		matchuser h1 = new matchuser();
		hmap= h1.getUser("lwhite");
		int p = hmap.get("ssdiproject");
		assertFalse("matches present for this user",hmap.isEmpty());
		assertEquals("testing number of matches for a particular user",2,p);
        assertTrue("testing one of matching option",hmap.containsKey("pratyusha"));
        assertFalse("not matched user",hmap.containsKey("anjani"));
        matchuser h2 = new matchuser();
        h1map=h2.getUser("anjani");
        assertTrue("no matches for this user",h1map.isEmpty());
          
    }


}
