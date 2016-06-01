package gui;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import AccountSection.Account;
import AccountSection.AccountHelper;

public class StartClient {
	 public static void main(String[] args) {
	      try {
		    ORB orb = ORB.init(args, null);
		    org.omg.CORBA.Object objRef =   orb.resolve_initial_references("NameService");
		    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		    Account addobj = (Account) AccountHelper.narrow(ncRef.resolve_str("account"));
		    new AccountManager(addobj);
	            
	       }
	       catch (Exception e) {
	          System.out.println("Hello Client exception: " + e);
		  e.printStackTrace();
	       }
	 
	    }
}
