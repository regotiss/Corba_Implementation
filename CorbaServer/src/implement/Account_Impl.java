package implement;
import AccountSection.AccountPOA;
public class Account_Impl extends AccountPOA{
	int balance;
	Account_Impl(){
		balance=0;
	}
	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		if(amount>0){
			balance+=amount;
			System.out.println("Deposited Succesfully\nCurrent Balance:"+balance);
		}
		else{
			System.out.println("Please check amount again..!");
		}
	}
	@Override
	public void withdraw(int amount) {
		if(amount<=balance){
			balance-=amount;
			System.out.println("Withdraw Succesfully");
		}
		else{
			System.out.println("Please check amount again..!");
		}
		System.out.println("Current Balance:"+balance);
		
	}
	@Override
	public int getBalance() {
		System.out.println("Current Balance:"+balance);
		return balance;
	}
	
}
