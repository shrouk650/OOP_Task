import javax.swing.JOptionPane;

public class Student_Grade {

	public static void main(String[] args) {
		
       //get number of students
		String numberOfStudents_String = JOptionPane.showInputDialog("Please Enter number of students");
		int numberOfStudents = Integer.parseInt(numberOfStudents_String);
		
		Student[] student_data = new Student[numberOfStudents];
		for(int i =0 ; i <student_data.length; i++){
			
			String student_name = JOptionPane.showInputDialog("Please enter name of Student " + (i +1) + " ");
			String student_email = JOptionPane.showInputDialog("Please enter Student email " + (i+1) + " ");
			String student_number_String = JOptionPane.showInputDialog("Please enter Student mobile number " + (i+1) + " ");
			int student_number = Integer.parseInt(student_number_String);
			String student_faculty = JOptionPane.showInputDialog("Please enter Student Faculty " + (i+1) + " ");
			
			Student student = new Student(student_name, student_email , student_number, student_faculty);
			
			String GradeNumber_string = JOptionPane.showInputDialog("Please enter number of Grades");
			int GradeNumber = Integer.parseInt(GradeNumber_string);
			
			Grade[] studentGrade = new Grade[GradeNumber];
			for(int j =0 ; j< studentGrade.length ; j++){
				
				String Grade_Name = JOptionPane.showInputDialog("Please enter name of Grade " + (j+1) + " " +" Name : ");
				String Grade_mark_string = JOptionPane.showInputDialog("Please enter mark of Grade " + (j+1) +" "+  " Mark : ");
				int Grade_mark = Integer.parseInt(Grade_mark_string);
				
				Grade grade = new Grade(Grade_Name, Grade_mark);
				studentGrade[j] = grade;
				}
			
			student.setStudentgrade(studentGrade);
			student_data[i] = student;
		}
		
		String result = "";
		String gradeExceed75= "";
		for (int i =0 ; i < student_data.length ; i++ ){
			
			result += "Student Number " + (i+1) + " Name : " + student_data[i].getName() + "\n";
			result += "Student Number " + (i+1) + " Email : " + student_data[i].getEmail() + "\n";
			result += "Student Number " + (i+1) + " Mobile number : " + student_data[i].getNumber() + "\n";
			result += "Student Number " + (i+1) + " Faculty : " + student_data[i].getFaculty() + "\n";
			
			if (student_data[i].getStudentgrade()!= null ){
				result += "         Student number " + (i+1) + " Grades :  \n";
				for (int j =0 ; j< student_data[i].getStudentgrade().length; j++){
					
				result += "         Student Grade Name : " + student_data[i].getStudentgrade()[j].getName() + " "+" Mark : "
							+ student_data[i].getStudentgrade()[j].getMark() + " \n";
					
					if (student_data[i].getStudentgrade()[j].getMark()>75){
						gradeExceed75 += " Student  " + student_data[i].getName() + " Mark is " + 
					    student_data[i].getStudentgrade()[j].getMark() + " in " + student_data[i].getStudentgrade()[j].getName()+"\n";
					}
				}
				result += "--------------------------------------------------------------------\n";
			}
			
			
		}
	
		result += "---------------------------------------------------------------------------------------\n"
		+ gradeExceed75;
		JOptionPane.showMessageDialog(null, result);
	}

	}


