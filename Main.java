package ap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
    	
    	
        
        
        Scanner sc = new Scanner(System.in);
        
        int[] keyarr1 = new int[5];
        String[] status = new String[3];
        //vaccine,dose no,duedate
        HashMap<Integer,Vaccine> vdata =new HashMap<>();
        HashMap<Integer,Hospital> hdata =new HashMap<>();
        HashMap<Integer,Citizen> cdata =new HashMap<>();
        HashMap<int[],Slots> sdata =new HashMap<>();
        HashMap<Integer,Slots> changes =new HashMap<>();
        HashMap<Long, String> citstatus =new HashMap<>();
        System.out.println("-----------------------------------");
        System.out.println("____Welcome to CoWin Portal____");
        System.out.println("-----------------------------------");
        
        

        while(true) {
        	System.out.println("-----------------------------------");
            System.out.println("Following are the Menu Options: ");
            System.out.println("1. Add Vaccine\n");
            System.out.println("2. Register Hospital \n");
            System.out.println("3. Register Citizen\n");
            System.out.println("4. Add Slot for Vaccination\n");
            System.out.println("5. Book Slot for Vaccination \n");
            System.out.println("6. List all slots for a hospital\n");
            System.out.println("7. Check Vaccination Status \n");
            System.out.println("8. Exit \n");
            System.out.println("-----------------------------------");
            
        	System.out.println("Enter the Query you wish to perform : ");
            int n = sc.nextInt();
            if(n==1) {
            	System.out.println("Enter vaccine name:");
            	String name = sc.next();
            	System.out.println("Enter Number of doses:");
            	int no_of_doses = sc.nextInt();
            	int gap = 0;
            	if(no_of_doses>1) {
            		System.out.println("Enter Gap between Doses:");
            		gap = sc.nextInt();
            	}else if(no_of_doses<0) {
            		System.out.println("Invalid input");
            	}
            	Vaccine v = new Vaccine(name,no_of_doses,gap);
            	
            	int num = vdata.size();
            	vdata.put(num , v);		    
		    	 System.out.print("Vaccine Name: " + v.name());
		    	 System.out.print(" Number of Doses: "+ v.doses() + " ");
	 		     System.out.print(" Gap Between Doses: " + v.gap()+" ");
	 		     System.out.println();
    		    	 
            }
            if(n==2) {
            	System.out.println("Enter Hospital name:");
            	String name = sc.next();
            	System.out.println("Enter PinCode:");
            	int pincode = sc.nextInt();
            	Random rand = new Random(); 
            	int h_id = rand.nextInt(999999);
        		String.format("%06d", h_id);
        		h_id = Integer.valueOf(h_id);
            	Hospital h = new Hospital(name,pincode,h_id);
            	int num = hdata.size();
            	hdata.put(num , h);		    
    		    if (hdata.containsKey(num)) {
    		    	 Hospital value = hdata.get(num);
    		    	 System.out.print("Hospital Name: " + value.name() + " ");
    		    	 System.out.print(", PinCode:  " + value.pincode() + " ");
         		     System.out.print(", Unique ID: " + value.h_id()+" ");
         		     System.out.println();
    		    	 }
            }
            if(n==3) {
            	System.out.println("Enter Citizen Name:");
            	String name = sc.next();
            	System.out.println("Enter Age:");
            	int age = sc.nextInt();
            	System.out.println("Enter Unique ID:");
            	long c_id = sc.nextLong();
            	Citizen c = new Citizen(name,age,c_id);
            	int num = cdata.size();
            	cdata.put(num , c);	
            	if(age<18) {
            		System.out.println(name + " " + age + " " + c_id);
            		System.out.println("Only above 18 are allowed");
            	}
            	else {
            		if(cdata.containsKey(num)) {
       		    	 Citizen value = cdata.get(num);
       		    	 System.out.print(": Citizen Name: " + value.name() + " ");
       		    	 System.out.print(",Age: "+ value.age() + " ");
            		 System.out.print(", Unique ID:"+ value.c_id()+" ");
            		 System.out.println();
       		    	 }
            	}
    		    
            	
            }
            if(n==4) {
            	System.out.println("Enter Hospital ID:");
            	int hid = sc.nextInt();
            	System.out.println("Enter number of Slots to be added:");
            	int slotnum = sc.nextInt();
            	System.out.println("Enter Day Number:");
            	int daynum = sc.nextInt();
            	System.out.println("Enter Quantity:");
            	int qty = sc.nextInt();
            	System.out.println("Select Vaccine:");
            	for (Entry<Integer, Vaccine> set : vdata.entrySet()) {
        		    System.out.println(set.getKey() + " " + set.getValue().name());
        		}
            	int v_id = sc.nextInt();
            	if(vdata.containsKey(v_id)) {
            		
            		Slots s = new Slots(slotnum,daynum,qty);
            		Vaccine value = vdata.get(v_id);
            		keyarr1[0] = sdata.size();
            		keyarr1[1] = v_id;
            		keyarr1[2] = hid;           		
              	    for(int i = 0; i<hdata.size();i++) {
              	    	
            			if(hdata.containsKey(i)) {
            				
             		    	 Hospital value1 = hdata.get(i);
             		    	 if(value1.h_id()==hid) { 
             		    		
             		    		int pin = value1.pincode();
             		    		keyarr1[3] = pin;
             		    		sdata.put(keyarr1, s);            		    		
             		    	 } 
             		    }
            		System.out.println("Slot added by Hospital" + hid + "for Day:" + daynum+ ", Available Quantity:" + 
            	    qty +" of Vaccine " + value.name() );
            	}
              }
            }if(n==5) {
            	System.out.println("Enter patient Unique ID:");
            	long cid = sc.nextLong();
            	System.out.println("1. Search by area\r\n"
            			+ "2. Search by Vaccine\r\n"
            			+ "3. Exit");
            	System.out.println("Enter option:");
            	int searchop = sc.nextInt();
            	if(searchop==1) {
            		System.out.println("Enter PinCode:");
            		int pin = sc.nextInt();
            		for(int i = 0; i<sdata.size();i++) {
            			List<int[]> p = new ArrayList<int[]>(sdata.keySet());
            			for(int[] j : p) {
            				Arrays.toString(j);
            				if(j[3]==pin) {
            					for(int t = 0; t<hdata.size();t++) {
                        			if(hdata.containsKey(t)) {
                         		    	 Hospital value2 = hdata.get(t);
                         		    	 if(value2.h_id()==j[2]) {
                         		    		System.out.println(j[2] + " "+ value2.h_id());  
                         		    		
                         		    		
                         		    	 } 
                         		    }
            					}
            				}
            				}
            			}
            		
            		System.out.println("Enter hospital id)");
            		int hchoice = sc.nextInt();
            		for(int i = 0; i<sdata.size();i++) {
            			List<int[]> hc = new ArrayList<int[]>(sdata.keySet());
            			for(int[] j : hc) {
            				Arrays.toString(j);
            				if(j[2]==hchoice && sdata.containsKey(j)) {
                 		    	 Slots value3 = sdata.get(j);                		    	 
                 		         int vid = j[1];
                 		         if(vdata.containsKey(vid)){
                 		        	 Slots s = new Slots(value3.slotnum(),value3.daynum(),value3.qty());
                 		        	 int count = 0;
                 		        	 changes.put(count , s);
                    		    	 System.out.println( count + "--> Day:" + value3.daynum() + " Available Qty:"+ value3.qty() +" Vaccine:");
                    		    	 count++;
//                    		    	 int temp = Slots.updateslot();
//                    		    	 if(temp>0) {
//                    		    		 status[1] = "Partially vaccinated";
//                    		    	 }else status[1] = "Fully vaccinated";
//                    		    	 
//                    		    	 citstatus.put(cid , status );
	                 		    	 Vaccine value4 = vdata.get(vid);
	                 		    	 System.out.println(value4.name());
	                 		    	 status[0]= value4.name();
	                 		    	 count++;}  
                         		    	 } 
                         		    }
            				}
            		System.out.println("Choose Slot: ");
            		int schoice = sc.nextInt();
            		for(int i = 0; i<sdata.size();i++) {
            			List<int[]> hc = new ArrayList<int[]>(sdata.keySet());
            			for(int[] j : hc) {
            				Arrays.toString(j);
            				if(j[2]==hchoice && sdata.containsKey(j)) {
                 		    	 Slots value3 = sdata.get(j);                		    	 
                 		         int vid = j[1];
                 		         if(changes.containsKey(schoice)){
                 		        	 
                    		    	 System.out.println(   "--> Day:" + value3.daynum() + " Available Qty:"+ value3.qty() +" Vaccine:");
	                 		    	 Vaccine value4 = vdata.get(vid);
	                 		    	 System.out.println(value4.name());
	                 		    	  }  
                         		    	 } 
                         		    }
            				}
            		
            				}
            			
             else if(searchop==2) {
            		System.out.println("Enter Vaccine name:");
            		String vname = sc.next();
            		int vid = 0;
            		for(int i = 0; i<vdata.size();i++) {
            			if(vdata.containsKey(i)) {
             		    	 Vaccine value = vdata.get(i);
             		    	 if(value.name()==vname) { 
             		    		vid = i;            		    		
             		    	 } 
             		    }
            	}for(int i = 0; i<sdata.size();i++) {
        			List<int[]> p = new ArrayList<int[]>(sdata.keySet());
        			for(int[] j : p) {
        				Arrays.toString(j);
        				if(j[1]==vid) {
        					for(int t = 0; t<hdata.size();t++) {
                    			if(hdata.containsKey(t)) {
                     		    	 Hospital value2 = hdata.get(t);
                     		    	 if(value2.h_id()==j[2]) {
                     		    		System.out.println(j[2] + " "+ value2.h_id());  
                     		    		Slots s = sdata.get(j);
                     		    		
                     		    	 } 
                     		    }
        					}
        				}
        				}
        			}
            		System.out.println("Enter hospital id:");
            		long hid = sc.nextLong();
            		for(int i = 0; i<sdata.size();i++) {
            			List<int[]> hc = new ArrayList<int[]>(sdata.keySet());
            			for(int[] j : hc) {
            				Arrays.toString(j);
            				if(j[2]==hid && sdata.containsKey(j)) {
                 		    	 Slots value3 = sdata.get(j);                		    	 
                 		         int vid1 = j[1];
                 		         if(vdata.containsKey(vid1)){
                 		        	 int count = 0;
                    		    	 System.out.println( count + "--> Day:" + value3.daynum() + " Available Qty:"+ value3.qty() +" Vaccine:");
	                 		    	 Vaccine value4 = vdata.get(vid1);
	                 		    	 System.out.println(value4.name()); }  
                         		    	 } 
                         		    }
            				}
            		System.out.println("Choose Slot: ");
            		int schoice = sc.nextInt();
            		for(int i = 0; i<sdata.size();i++) {
            			List<int[]> hc = new ArrayList<int[]>(sdata.keySet());
            			for(int[] j : hc) {
            				Arrays.toString(j);
            				if(j[2]== hid && sdata.containsKey(j)) {
                 		    	 Slots value3 = sdata.get(j);                		    	 
                 		         int vid1 = j[1];
                 		         if(changes.containsKey(schoice)){
                 		        	 
                    		    	 System.out.println(   "--> Day:" + value3.daynum() + " Available Qty:"+ value3.qty() +" Vaccine:");
	                 		    	 Vaccine value4 = vdata.get(vid);
	                 		    	 System.out.println(value4.name());
	                 		    	  }  
                         		    	 } 
                         		    }
            				}
            				}
            	
            	else if(searchop==3) continue;

            	
            }
        
            if(n==6) {
            	System.out.println("Enter Hospital Id:");
            	long hid = sc.nextLong();
            	for(int i = 0; i<sdata.size();i++) {
        			List<int[]> hc = new ArrayList<int[]>(sdata.keySet());
        			for(int[] j : hc) {
        				Arrays.toString(j);
        				if(j[2]==hid && sdata.containsKey(j)) {
             		    	 Slots value3 = sdata.get(j);                		    	 
             		         int vid = j[1];
             		         if(vdata.containsKey(vid)){
             		        	 int count = 0;
                		    	 System.out.print( " Day:" + value3.daynum()  +" Vaccine:");
                 		    	 Vaccine value4 = vdata.get(vid);
                 		    	 System.out.print(value4.name());
                 		    	 System.out.print("Available Qty:"+ value3.qty());
                 		    	 }  
                     		    	 } 
                     		    }
        				}
            	
            	
            }
            if(n==7) {
            	System.out.println("Enter Patient ID:");
            	long cid = sc.nextLong();
            	for(int i = 0; i<cdata.size();i++) {
        			if(cdata.containsKey(i)) {
         		    	 Citizen value5 = cdata.get(i);
         		    	 if(value5.c_id()==cid) { 
         		    		System.out.print(i + " " + value5.name() );
         		    		System.out.println("Vaccine Given:" + " ");
         		    		
         		    		
         		    		
         		    	 } 
         		    }
        	}
            	System.out.println("Vaccine Given:" + " ");
            	System.out.println("Number of Doses given:" + " ");
            	System.out.println("Next Dose due date:" + " ");
            	
            }
            if(n==8) {
            	System.out.println("--------ThankYou----------");
            	break;
            }
            if(n<1|n>8){
            	System.out.println("Invalid input");
            	continue;
            }
            
        }
        
        





    }
}