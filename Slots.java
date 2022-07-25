package ap;

public class Slots{
	public long h_id ;
	public long c_id ; 
	private int slotnum;
	private int daynum;
	public int qty;
	public int num = 0;
	
	
	
	 public Slots(int slotnum,int daynum,int qty){
	        this.slotnum=slotnum;
	        this.daynum=daynum;
	        this.qty = qty;
	    }
	 
	 public int slotnum(){
	        return this.slotnum;
	    }
	 public int daynum(){
	        return this.daynum;
	    }
	 public int qty(){
	        return this.qty;
	    }
	 public int updateslot() {
		 return this.qty--;
	 }
		 
//	  public static int dosegiven() {
//		 this.num++
//		  return num;
//		 
//	 }
	   
}
