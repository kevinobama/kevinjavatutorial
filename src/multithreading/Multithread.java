package multithreading;

public class Multithread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
        	MultithreadingOne object= new MultithreadingOne();
            object.start();
        }       
	}
}