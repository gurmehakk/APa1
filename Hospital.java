package ap;

import java.util.HashMap;
import java.util.Iterator;

public class Hospital {
	private String name;
	private int pincode;
	public int h_id ;
	private int slots;
	
 
    
    public Hospital(String name , int pincode , int h_id ){
        this.name=name;
        this.pincode=pincode;
        this.h_id=h_id;
        
    }
    
    public String name(){
        return this.name;
    }
    public int pincode(){
        return this.pincode;
    }
    public int h_id(){
        return h_id;
    }
  

}
    
   
    

