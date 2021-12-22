import Enums.StudyProfile;
import Models.Student;
import Models.University;

public class Main {
    public static void main(String[] args) {
        // creating university object
        University university = new University();
        university.setId("00001");
        university.setFullName("British Higher School of Art and Design");
        university.setShortName("BHSAD");
        university.setYearOfFoundation(2003);
        university.setMainProfile(StudyProfile.DESIGN);

        // creating student object
        Student student = new Student();
        student.setUniversityId("00001");
        student.setFullName("Jack Sparrow");
        student.setCurrentCourseNumber(145);
        student.setAvgExamScore((float) 5);

        // console output
        System.out.println(university);
        System.out.println(student);

        // to be continued...
    }
}