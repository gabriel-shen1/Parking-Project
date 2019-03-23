import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;


public class hash {

	private static final String pepper = "abcdefg123";
	private static final String algo = "SHA-512";
	public static String password = "";
	public static String hashedPassword = "tmp";
	
	public hash(String password){
		this.password = password;
	}
	
	public static String getHash(){
		String pepperedpassword  = password + pepper;
		byte[] input = pepperedpassword.getBytes();
		String hash = "";
		try{
			MessageDigest messageDigest = MessageDigest.getInstance(algo);
			messageDigest.update(input);
			byte[] db = messageDigest.digest();
			hash = DatatypeConverter.printHexBinary(db).toLowerCase();
			
		}catch(Exception e){
			
		}
		hashedPassword = hash;
		return hash;
	}
	
	public String getHashedPassword(){
		return hashedPassword;
	}
}
