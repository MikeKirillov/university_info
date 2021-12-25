import Models.Student;
import Models.University;
import io.XlsFileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    private final static String FILE_PATH = "src/main/resources/universityInfo01.xlsx";

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(FILE_PATH);

/*
        List<University> universities = XlsFileReader.readUniversity(FILE_PATH);
        List<Student> students = XlsFileReader.readStudent(FILE_PATH);

        for (University university : universities) {
            System.out.println(university);
        }

        for (Student student : students) {
            System.out.println(student);
        }
*/
    }
}