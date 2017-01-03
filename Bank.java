import java.util.*;
class SharedClass
{
	double tamt,initialAmount = 0;
	Scanner obj = new Scanner(System.in);
	public synchronized void deposit()
	{
		
		System.out.println("Enter Account no. for deposit.");
		int acc = obj.nextInt();
		System.out.println("How much amount do you want to deposit?");
		double amt = obj.nextDouble();
		tamt = amt + initialAmount ;
		System.out.println("Available Balance : "+tamt);
	}
	
	public synchronized void withdrawal()
	{
		System.out.println("Enter Account no. for withdrawal.");
		int acc1 = obj.nextInt();
		System.out.println("How much amount do you want to withdraw?");
		double amtW = obj.nextDouble();
		double amtL = tamt - amtW;
		System.out.println("Amount Available : "+amtL);
	}
}

public class Bank {

	static SharedClass s = new SharedClass();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread()
				{
			public void run()
			{
				s.deposit();
			}
				};
		Thread t2 = new Thread()
				{
			public void run()
			{
				s.withdrawal();
			}
				};
				t1.start();
				t2.start();
	}

}
