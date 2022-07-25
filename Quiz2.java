package ap;

public class Quiz2 {
	public class G1 extends repair{
		
	}
	public class G2{
		
	}
	public class repair implements bike,car{
		
	}
	public abstract class replace implements bike,car{
		
		
	}
	interface bike{
		
		
	}
	interface car{
		public static void repaircar() {
			System.out.println("turned off");
		}
		public static void replacecarws() {
			System.out.println("clean engine mode on");
		}
	}

}
