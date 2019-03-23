

public class security {
	

	public static void main(String[] args)  {
	String pssw = "testpssw";
	System.out.println("Test password is: "+ pssw);
	hash ps2 = new hash(pssw);
	String hashedpssw = ps2.getHash();
	System.out.println("Hashed password is "+ hashedpssw);
	
		
		
	}
	


}
