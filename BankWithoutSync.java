/*WITHOUT SYNCHRONIZATION BOTH FUNCTIONS deposit() and withdrawal() are running in any manner so it
IS BETTER to use sync to make this program run in a meaningful way. THIS IS HAPPENING BECAUSE OF 
context switch process ( in the case of without sync ) */


import java.util.Scanner;
class ShareddClass
{
	double tamt,initialAmount = 0;
	Scanner obj = new Scanner(System.in);
	public void deposit()
	{
		
		System.out.println("Enter Account no. for deposit.");
		int acc = obj.nextInt();
		System.out.println("How much amount do you want to deposit?");
		double amt = obj.nextDouble();
		tamt = amt + initialAmount ;
		System.out.println("Available Balance : "+tamt);
	}
	
	public void withdrawal()
	{
		System.out.println("Enter Account no. for withdrawal.");
		int acc1 = obj.nextInt();
		System.out.println("How much amount do you want to withdraw?");
		double amtW = obj.nextDouble();
		double amtL = tamt - amtW;
		System.out.println("Amount Available : "+amtL);
	}
}

public class BankWithoutSync {

	static ShareddClass s1 = new ShareddClass();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread()
				{
			public void run()
			{
				s1.deposit();
			}
				};
		Thread t2 = new Thread()
				{
			public void run()
			{
				s1.withdrawal();
			}
				};
				t1.start();
				t2.start();
	}

}
