package ap;

public class Vaccine {

    public String name;
    private int no_of_doses;
    private int gap;
    
    public Vaccine(String name,int id, int gap){
        this.name=name;
        this.no_of_doses=no_of_doses;
        this.gap=gap;
    }
    public String name(){
        return this.name;
    }
    public int doses(){
        return this.no_of_doses;
    }
    public int gap(){
        return this.gap;
    }
    
	
	
	

}
