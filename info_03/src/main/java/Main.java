import Models.Student;
import Models.University;
import io.XlsFileReader;

import java.io.IOException;
import java.util.List;

public class Main {
    private final static String PATH = "/Users/michaelkirillov/IdeaProjects/university_info/" +
            "info_02/src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) throws IOException {
        List<University> universities = XlsFileReader.readUniversity(PATH);
        List<Student> students = XlsFileReader.readStudent(PATH);

        for (University university : universities) {
            System.out.println(university);
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}