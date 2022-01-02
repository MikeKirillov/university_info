import Comparator.StudentComparator;
import Comparator.UniversityComparator;
import Enums.StudentComparatorType;
import Enums.UniversityComparatorType;
import Models.Student;
import Models.University;
import Util.ComparatorUtil;
import io.XlsFileReader;

import java.io.IOException;
import java.util.List;

public class Main {
    private final static String PATH = "/Users/michaelkirillov/IdeaProjects/university_info/" +
            "info_02/src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) throws IOException {
        List<University> universities = XlsFileReader.readUniversity(PATH);
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students = XlsFileReader.readStudent(PATH);
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}