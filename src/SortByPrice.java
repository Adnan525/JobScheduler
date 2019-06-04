import java.util.*;
public class SortByPrice implements Comparator<ServerFromXML>{

	@Override
	public int compare(ServerFromXML o1, ServerFromXML o2) {
		// TODO Auto-generated method stub
		return (o1.rate > o2.rate) ? 1 : -1;
	}

}
