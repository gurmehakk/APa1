package ap;

public class Q1 {
	public static void main(String[] args) {
		Bird B1 = new Eagle("Bird1");
		Bird B2 = new Eagle("Bird2");
		B1.eat();
		B2.fly(B1);
	}
	public interface Bird{
		public void eat();
		public void fly(Bird B);
		public String getname();
	}
	Class Eagle implements Bird{
		private String name;
		public Eagle(string name) {
			name = name;
		}
		public void eat() {
			System.out.println("Eagle eats");
		}
		public String getname() {
			return this.name;
		}
		public void fly(Bird B) {
			System.out.println(this.name + "flying with " + B.getname());;
		}
	}

}
