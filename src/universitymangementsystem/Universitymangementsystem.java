package universitymangementsystem;
import java.util.ArrayList;
import java.util.List;
class University {

    private List<Teacher> teachers;
    private List<Student> students;
    private static int  totalMoneyEarned;
    private static int totalMoneySpent;

//    /**
//     * new university object is created.
//     * @param teachers list of teachers in the university.
//     * @param students list of students int the unversity.
//     */
    public University(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }

    /**
     *
     * @return the list of teachers int the University.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

//    /**
//     * Adds a teacher to the Unversity.
//     * @param teacher the teacher to be added.
//     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     *
     * @return the list of students in the University.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a student to the University
     * @param student the student to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     *
     * @return the total money earned by the University.
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Adds the total money earned by the University.
     * @param MoneyEarned money that is supposed to be  added.
     */
    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    /**
     *
     * @return the total money spent by the University.
     */
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }
    /**
     * update the money that is spent by the University which
     * is the salary given by the University to its teachers.
     * @param moneySpent the money spent by University.
     */
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneyEarned-=moneySpent;
     }
}
class Teacher {

    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    /**
     * Creates a new Teacher object.
     * @param id id for the teacher.
     * @param name name of the teacher.
     * @param salary salary of the teacher.
     */
    public Teacher(int id, String name, int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.salaryEarned=0;
    }

    /**
     *
     * @return the id of the teacher.
     */
    public int getId(){
        return id;
    }

    /**
     *
     * @return name of the teacher.
     */
    public String getName(){
        return name;
    }


    /**
     *
     * @return the salary of the teacher.
     */
    public int getSalary(){
        return  salary;
    }

    /**
     * set the salary.
     * @param salary
     */
    public void setSalary(int salary){
        this.salary=salary;
    }

    /**
     * Adds  to salaryEarned.
     * Removes from the total money earned by the University.
     * @param salary
     */
    public void receiveSalary(int salary){
        salaryEarned+=salary;
        University.updateTotalMoneySpent(salary);
    }


    @Override
    public String toString() {
        return "Name of the Teacher: " + name
                +" Total salary earned so far "
                + salaryEarned;
    }
}
class Student {

    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * To create a new student by initializing.
     * Fees for every student is $76,000.
     * Fees paid initially is 0.
     * @param id id for the student: unique.
     * @param name name of the student.
     * @param grade grade of the student.
     */
    public Student(int id, String name,int grade){
        this.feesPaid=0;
        this.feesTotal=30000;
        this.id=id;
        this.name=name;
        this.grade=grade;

    }

    //Not going to alter student's name, student's id.


    /**
     * Used to update the student's grade.
     * @param grade new grade of the student.
     */
    public void setGrade(int grade){
        this.grade=grade;
    }


    /**
     * Keep adding the fees to feesPaid Field.
     * Add the fees to the fees paid.
     * The school is going receive the funds.
     *
     * @param fees the fees that the student pays.
     */
    public void payFees(int fees){
        feesPaid+=fees;
        University.updateTotalMoneyEarned(feesPaid);
    }

    /**
     *
     * @return id of the student.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the grade of the student.
     */
    public int getGrade() {
        return grade;
    }

    /**
     *
     * @return fees paid by the student.
     */
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     *
     * @return the total fees of the student.
     */
    public int getFeesTotal() {
        return feesTotal;
    }

    /**
     *
     * @return the remaining fees.
     */
    public int getRemainingFees(){
        return feesTotal-feesPaid;
    }

    @Override
    public String toString() {
        return "Student's name :"+name+
                " Total fees paid so far "+ feesPaid;
    }
}





public class Universitymangementsystem {
    public static void main(String[] args) {
        Teacher Savera = new Teacher(1,"Miss Savera",50000);
        Teacher Humna = new Teacher(2,"Miss Humna",70000);
        Teacher Nimra = new Teacher(3,"Miss Nimra",60000);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(Savera);
        teacherList.add(Humna);
        teacherList.add(Nimra);


        Student Arsalan = new Student(1,"Mohammad Arsalan Ali",4);
        Student Shahzaib = new Student(2,"Shahzaib",12);
        Student Hamza = new Student(3,"Mohammad Hamza",5);
        List<Student> studentList = new ArrayList<>();

        studentList.add(Arsalan);
        studentList.add(Shahzaib);
        studentList.add(Hamza);


        University jinnah = new University(teacherList,studentList);

        Teacher Rida = new Teacher(6,"Miss Rida", 9000);

        jinnah.addTeacher(Rida);


        Arsalan.payFees(50000);
        Shahzaib.payFees(76000);
        System.out.println("<=========================================================================>");
        System.out.println("Indus University has earned "+ jinnah.getTotalMoneyEarned());
        System.out.println("<------------------------------------------------------------------------>");
        System.out.println("------Making University PAY SALARY----");
        Savera.receiveSalary(Savera.getSalary());
        System.out.println("Indus University has spent for salary to " + Savera.getName()
        +" and now has " + jinnah.getTotalMoneyEarned());
        System.out.println("<------------------------------------------------------------------------>");
        Nimra.receiveSalary(Nimra.getSalary());
        System.out.println("Indus University has spent for salary to " + Nimra.getName()
                +" and now has " + jinnah.getTotalMoneyEarned());
        System.out.println("<------------------------------------------------------------------------>");
        System.out.println(Shahzaib);
        System.out.println("<------------------------------------------------------------------------>");
        Humna.receiveSalary(Humna.getSalary());
        System.out.println(Humna);
        System.out.println("<==============================THANKYOU===================================>");

    }
}


