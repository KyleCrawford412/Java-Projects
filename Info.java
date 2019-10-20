public class Info {

	private int age;
	private double height;
	private String name;
	private String eyeColor;

	public Info(String inName, int inAge, double inHeight, String inEyeColor) {
		age = inAge;
		height = inHeight;
		name = inName;
		eyeColor = inEyeColor;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int newAge) {
		age = newAge;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double newHeight) {
		height = newHeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String newEyeColor) {
		eyeColor = newEyeColor;
	}

	public String toString() {
		return "Name:\t\t" + name + "\nHeight:\t\t" + height + "\nAge:\t\t" + age + "\nEye Color:\t" + eyeColor + "\n";
	}
	
}