
package ps2;

class Employee{
    String name;
    double salary;
    Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }
    String getName(){
        return name;
    }
    double getSalary(){
        return salary;
    }  
}

class Student{
    String name;
    double totalQuizScore;
    int nq;
    Student(String name, double totalQuizScore){
        this.name = name;
        this.nq= 1;
        this.totalQuizScore = totalQuizScore;
    }
    double getTotalScore(){
        return totalQuizScore;
    }
    void addQuizScore(double score){
        totalQuizScore+=score;
        nq+=1;
    }
    double getAverageScore(){
        return totalQuizScore/nq;
    }
    
}

class Car{
    float fuelEfficiency;
    float fuelLeft;
    Car(float eff){
        this.fuelEfficiency = eff;
        this.fuelLeft = 0;
    }
    
    float getFuelLevel(){
        return this.fuelLeft;
    }
    void tank(float fuel){
        fuelLeft+=fuel;
    }
    void drive(float kms){
        float fuelTaken = kms/fuelEfficiency;
        fuelLeft-=fuelTaken;
    }
}

class LongStringLength{
    static int[] columnMax(String[][] str){
        int row = str.length;
        int col = str[0].length;
        int arr[] = new int[col];
        for(int i=0;i<col;i++){
            int maxlen = str[0][i].length();
            String maxStr= str[0][i];
            for(int j=1;j<row;j++){
                if(str[j][i].length()>maxlen){
                    maxlen = str[j][i].length();
                    maxStr = str[j][i];
                }
            }
            System.out.println(maxStr);
            arr[i] = maxlen;
        }
        return arr;   
    }
}

class Triangle{
    double length,width,area;
    double a,b,c;
    String colour;
    Triangle(){
        a=b=c=0;
    }
    Triangle(int x, int y, int z){
         a=x;
         b=y;
         c=z;
    }
    Triangle(Triangle temp){
        this.a = temp.a;
        this.b = temp.b;
        this.c = temp.c;
    }
    
    void set_length(double length){
        this.length = length;
    }
    void set_width(double width){
        this.width = width;
    }
    void set_colour(String colour){
        this.colour = colour;
    }
    Boolean isTriangle(){
        if(a+b>c){
            return true;
        }
        else return false;
    }
    boolean isRight(){    
        if(this.isTriangle() &&a*a+b*b == c*c ){
            return true;
        }
        return false;
    }
    boolean isIsosceles(){
        if (this.isTriangle() && (a==b || b==c || c==a)){
            return true;
        }
        return false;
    }
    boolean isScalene(){
        if (this.isTriangle() && (a!=b && b!=c && c!=a)){
            return true;
        }
        return false;
    }
    boolean isEquilateral(){
        if (this.isTriangle() && (a==b && b==c && c==a)){
            return true;
        }
        return false;
    }
    
    boolean match_Rect(Triangle t){
        double a1 = 1/2*this.length*this.width;
        double a2 = 1/2*t.length*t.width;
        if(a1==a2 && this.colour==t.colour)
            return true;
        else
            return false;
    }
    
}
public class PS2 {
    public static void main(String[] args) {
//      Employee emp = new Employee("Sandeep",1000000);
//      System.out.println(emp.getName());
//      System.out.println(emp.getSalary());

//        Student std = new Student("Vatsan",5);
//        std.addQuizScore(20);
//        System.out.println(std.getAverageScore());
//        Car mycar = new Car(29);
//        mycar.tank(20);
//        mycar.drive(100);
//        System.out.println(mycar.getFuelLevel());
//          String[][] a = {{"help", "ok", "city lights"},
//                        {"elvisLives", "hello", "punch-out"},
//                        {"hurrah", "humptydumpty", "123"}};
//          int arr[] =LongStringLength.columnMax(a);
//          for(int i=0;i<arr.length;i++)
//              System.out.print(arr[i]+ " ");
//
//        Triangle t1 = new Triangle(15,15,18);
//        t1.set_width(18);
//        t1.set_length(12);
//        t1.set_colour("red");
//        Triangle t2 = new Triangle(15,15,18);
//        t2.set_width(18);
//        t2.set_length(12);
//        t2.set_colour("red");
//        System.out.println(t1.match_Rect(t2));
    }
    
}
