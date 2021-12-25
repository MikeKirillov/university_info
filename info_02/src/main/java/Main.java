import Models.Student;
import Models.University;
import io.XlsFileReader;

import java.io.IOException;
import java.util.List;

public class Main {
    private final static String FILE_PATH = "src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) throws IOException {
        List<University> universities = XlsFileReader.readUniversity(FILE_PATH);
        List<Student> students = XlsFileReader.readStudent(FILE_PATH);

        for (University university : universities) {
            System.out.println(university);
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}