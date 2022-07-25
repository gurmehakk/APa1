package ap;

public class Citizen {
	private String name;
	private int age;
	private long c_id;
    private String status;
    private Vaccine vac_name;
    
    public Citizen(String name , int age , long c_id){
        this.c_id=c_id;
        this.name=name;
        this.age=age;
        this.status="registered";
    }
//    public String setstatus(){
//    	if(Slots.qty()<this.qty)
//        return this.status=status;
//    }
    public void changestatus(int temp) {
    	if(temp == 1) {
    		
    	}else if(temp==2) {
    		
    	}
    }
    
    
    public String name(){
        return this.name=name;
    }
    public int age(){
        return this.age;
    }
    public long c_id(){
        return c_id;
    }

}
