package implement;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import AccountSection.Account;
import AccountSection.AccountHelper;

public class StartServer {

	public static void main(String[] args) {
		
		try{
		 
		  //initialize the ORB 
	      ORB orb = ORB.init(args, null);     
	      
	      //obtain reference to root POA and its Manager
	      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	      rootpoa.the_POAManager().activate();
	 
	      // create servant and register it with the ORB
	      Account_Impl accobj = new Account_Impl();
	     
	 
	      // get object reference from the servant
	      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(accobj);
	      Account href = AccountHelper.narrow(ref);
	 
	      org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
	      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	 
	      NameComponent path[] = ncRef.to_name( "account" );
	      ncRef.rebind(path, href);
	 
	      System.out.println("Server ready and waiting ...");
	 
	      // wait for invocations from clients
	      for (;;){
		  orb.run();
	      }
	    } 
	 
	    catch (Exception e) {
	        System.err.println("ERROR: " + e);
	        e.printStackTrace(System.out);
	     }
	 
	      System.out.println("Server Exiting ...");

	}

}
