

public class InfoClass {

    public int studentNum;
    public String name;
    public int grade; 
    public double gpa; 
    
    
    public InfoClass(int studentNum, String name, int grade, double gpa){
    	this.studentNum = studentNum;
    	this.name = name;
    	this.grade = grade;
    	this.gpa = gpa;
    }
    
    
   public void setNum(int num){
   	studentNum = num;
   }
    
   public int getNum(){
   	return studentNum;
   }
    
   public void setName(String nm){
   	name = nm;
   }
    
   public String getName(){
   	return name;
   } 
    
   public void setGrade(int g){
   	grade = g;
   }
    
   public int getGrade(){
   	return grade;
   } 
   
   public void setGPA(double sGPA){
   	gpa = sGPA;
   }
    
   public double getGPA(){
   	return gpa;
   }
   
   public String toString(){
	   	String str;
	   	
	   	str = "Student Number:   "+studentNum+"\n" +
	   		  "Name:   "+name+"\n" +
	   		  "Grade:   "+grade+"\n" +
	   		  "GPA:   "+gpa+"\n";
	   		  return str;
	   }
   
   
   
}