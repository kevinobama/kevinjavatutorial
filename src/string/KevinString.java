package string;

public class KevinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String userName ="china";
		String userName1 = "china";
		
		if(userName==userName1) 
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		if(userName.equals(userName1)) 
			System.out.println("equal");
		else
			System.out.println("not equal");
			
		int x =1;
		Integer y= 1;
		
		if(y.equals(x)) 
			System.out.println("equal");
		else
			System.out.println("not equal");
		
		if(x==y) 
			System.out.println("equal");
		else
			System.out.println("not equal");
	}
}
