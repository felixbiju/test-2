package bankingapp1.ui;
import bankingapp1.bean.*;
public class Demo {
	public static void main(String[] args) {
		Customer ob1 = new Customer();
		ob1.acceptValues(100, "Rahil Nagar", "Thane", "BOP231");
	String res = ob1.display();
	System.out.println(res);
	}
	
}
