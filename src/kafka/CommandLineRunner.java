package kafka;

public class CommandLineRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		index("US","UK");
		
	}
	
	public static void index(String... arg) {
		
		System.out.println(arg);
		System.out.println(arg[0]);
		System.out.println(arg[1]);
	}	

}
