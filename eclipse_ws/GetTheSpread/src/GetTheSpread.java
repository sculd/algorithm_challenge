import java.util.*;

class Solution {
	static void print_ts(HashMap<Integer, Double> ts){
		System.out.println("(print_ts)");
		SortedSet<Integer> sorted = new TreeSet<Integer>(ts.keySet());
		Iterator<Integer> it = sorted.iterator();
		while (it.hasNext())	{
			Integer now = it.next();
			System.out.println(now + ": " + ts.get(now));
		}		
	}
	
	//Each timeseries in represented as a key-value object, where keys are times and values are prices.
	//We simply take two timeseries key-value objects and return one that has times in 10 second intervals.
	public HashMap<Integer, Double> getSpreadTimeSeries(HashMap<Integer, Double> ts1, HashMap<Integer, Double> ts2) {
	    //Implement this, return a key-value object.
	
		// soft w.r.t. time of the events
		SortedSet<Integer> times1 = new TreeSet<Integer>(ts1.keySet());
		SortedSet<Integer> times2 = new TreeSet<Integer>(ts2.keySet());
	    HashMap<Integer, Double> answer = new HashMap<Integer, Double>();
	    if (times1.size() == 0 & times2.size() == 0)
	    	return answer;
		Iterator<Integer> it1 = times1.iterator();
		Iterator<Integer> it2 = times2.iterator();
	    
		// time of reference for the answer
		int cur = 0;
		
		// time is the nearest event time before cur
		Integer time1 = (it1.hasNext())? it1.next() : null;
		Integer time2 = (it2.hasNext())? it2.next() : null;

		// next is the nearest event after cur
		Integer next1 = (it1.hasNext())? it1.next() : null;
		Integer next2 = (it2.hasNext())? it2.next() : null;
		
	    while (true) {
	    	Double spread = null;
	    	if (time1 <= cur && time2 <= cur)
	    		spread = Math.abs(ts1.get(time1) - ts2.get(time2));
	    	answer.put(cur, spread);
	    	
	    	// now it done with the current cur
	    	cur += 10;
	    	
	    	// find the nearest events after cur
	    	while (next1 != null && next1 <= cur)	{
	    		time1 = next1;
	    		next1 = (it1.hasNext())? it1.next() : null;
	    	}
	    	while (next2 != null && next2 <= cur)	{
	    		time2 = next2;
	    		next2 = (it2.hasNext())? it2.next() : null;
	    	}
	    	
	    	if (next1 == null && next2 == null)
	    		break;
	    }
	    
    	Double spread = null;
    	if (time1 <= cur && time2 <= cur)
    		spread = Math.abs(ts1.get(time1) - ts2.get(time2));
	    if (cur > 0 && answer.get(cur - 10).compareTo(spread) != 0)
	    	answer.put(cur, spread);
	    
	    return answer;
	}	
}

public class GetTheSpread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		HashMap<Integer, Double> ts1 = new HashMap<Integer, Double>();
		HashMap<Integer, Double> ts2 = new HashMap<Integer, Double>();
		ts1.put(0, 1.0);
		ts1.put(4, 23.0);
		
		ts2.put(0, 1.0);
		ts2.put(4, 12.0);
		ts2.put(30, 13.0);

		Solution.print_ts(ts1);
		Solution.print_ts(ts2);
		HashMap<Integer, Double> answer = sol.getSpreadTimeSeries(ts1, ts2);		
		Solution.print_ts(answer);
	}

}
