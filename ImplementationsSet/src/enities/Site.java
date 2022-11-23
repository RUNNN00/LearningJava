package enities;

import java.util.HashSet;
import java.util.Set;

public class Site {

	private Set<Access> entries;

	public Site() {
		entries = new HashSet<Access>();
	}
	
	public void entry(Access entry) {
		
		entries.add(entry);
	}
	
	public int accessCount() {
		
		return entries.size();
	}
}
