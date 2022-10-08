package enities;

import java.util.HashSet;
import java.util.Set;

public class Site {

	private Set<Access> accessList;

	public Site() {
		accessList = new HashSet<Access>();
	}
	
	public void entry(Access hit) {
		
		accessList.add(hit);
	}
	
	public int accessCount() {
		
		return accessList.size();
	}
}
