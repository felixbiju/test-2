package bankingapp1.bean;

public class Customer {
    public int cid;
	public String cname;
	public String caddress;
	public String cpan;
	
	public void acceptValues(int cid, String cname, String caddress, String cpan)
	{
		this.cid=cid;
		this.cname=cname;
		this.caddress=caddress;
		this.cpan=cpan;
	}
	
	public String display()
	{
		String s = "Customer id is  "+cid+"\n "+"Customer name is" +cname+"\n "+"Customer address is"+caddress+"\n "+"Customer pancard number is"+cpan;
		return s;
	}
}
