package AccountSection;


/**
* AccountSection/AccountPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from account.idl
* Sunday, February 7, 2016 10:17:04 PM IST
*/

public abstract class AccountPOA extends org.omg.PortableServer.Servant
 implements AccountSection.AccountOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable<String, Integer> _methods = new java.util.Hashtable<String, Integer> ();
  static
  {
    _methods.put ("deposit", new java.lang.Integer (0));
    _methods.put ("withdraw", new java.lang.Integer (1));
    _methods.put ("getBalance", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = _methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // AccountSection/Account/deposit
       {
         int amount = in.read_long ();
         this.deposit (amount);
         out = $rh.createReply();
         break;
       }

       case 1:  // AccountSection/Account/withdraw
       {
         int amount = in.read_long ();
         this.withdraw (amount);
         out = $rh.createReply();
         break;
       }

       case 2:  // AccountSection/Account/getBalance
       {
         int $result = (int)0;
         $result = this.getBalance ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:AccountSection/Account:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Account _this() 
  {
    return AccountHelper.narrow(
    super._this_object());
  }

  public Account _this(org.omg.CORBA.ORB orb) 
  {
    return AccountHelper.narrow(
    super._this_object(orb));
  }


} // class AccountPOA