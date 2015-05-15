class Coordinate {
	double x, y, z;
}

class Solution {
	//Given 3 coordinates each with dimensions in x, y and z, tell us if the balcony is
    //perpendicular to the tower.
    //
    //A Coordinate is an object that simply stores an x, y and z coordinate. All doubles.
    //
    //The vector formed between co1 and co2 represents the tower, the vector
    //formed between the midpoint of the tower and co3 represents the balcony.
	public boolean checkBalconyBeam(Coordinate co1, Coordinate co2, Coordinate co3) {
		//Please implement this
	    
	    Coordinate tower = new Coordinate();
	    tower.x = co2.x - co1.x;
	    tower.y = co2.y - co1.y;
	    tower.z = co2.z - co1.z;
	    
	    Coordinate mid = new Coordinate();
	    mid.x = (co2.x + co1.x) / 2;
	    mid.y = (co2.y + co1.y) / 2;
	    mid.z = (co2.z + co1.z) / 2;
	    
	    Coordinate balcony = new Coordinate();
	    balcony.x = (co3.x - mid.x) / 2;
	    balcony.y = (co3.y - mid.y) / 2;
	    balcony.z = (co3.z - mid.z) / 2;
	    
	    // inner product of tower and balcony. The inner product of prerpendicular vectors is zero.
	    double inner_prod = 0;
	    inner_prod += tower.x * balcony.x;
	    inner_prod += tower.y * balcony.y;
	    inner_prod += tower.z * balcony.z;
	    
	    // consider the precision error
	    return Math.abs(inner_prod) < 0.0001;
	}
}

public class LeaningBalconiesOfPisa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		Coordinate co1 = new Coordinate();
		co1.x = 0; co1.y = 0; co1.z = 0; 
		Coordinate co2 = new Coordinate();
		co2.x = 0; co2.y = 0; co2.z = 10;
		Coordinate co3 = new Coordinate();
		co3.x = 1; co3.y = 0; co3.z = 5;
		
		System.out.println(sol.checkBalconyBeam(co1, co2, co3));
	}

}
