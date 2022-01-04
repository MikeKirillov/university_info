import Comparator.StudentComparator;
import Comparator.UniversityComparator;
import Enums.StudentComparatorType;
import Enums.UniversityComparatorType;
import Models.Student;
import Models.University;
import Util.ComparatorUtil;
import Util.JsonUtil;
import io.XlsFileReader;

import java.io.IOException;
import java.util.List;

public class Main {
    private final static String PATH = "/Users/michaelkirillov/IdeaProjects/university_info/" +
            "info_02/src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) throws IOException {
        List<University> universities = XlsFileReader.readUniversity(PATH);
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);

        String universitiesJson = JsonUtil.universityListJson(universities);
        System.out.println(universitiesJson);// checking created JSON from list

        List<University> universitiesFromJson = JsonUtil.jsonUniversityList(universitiesJson);
        System.out.println(universitiesFromJson.size() == universities.size());// checking created list from JSON

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityJson(university);
            System.out.println(universityJson);// checking created JSON of 1 object

            University universityFromJson = JsonUtil.jsonUniversity(universityJson);
            System.out.println(universityFromJson);// checking created object from JSON
        });

        List<Student> students = XlsFileReader.readStudent(PATH);
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);

        String studentsJson = JsonUtil.studentListJson(students);
        System.out.println(studentsJson);

        List<Student> studentsFromJson = JsonUtil.jsonStudentList(studentsJson);
        System.out.println(studentsFromJson.size() == students.size());

        students.forEach(student -> {
            String studentJson = JsonUtil.studentJson(student);
            System.out.println(studentJson);

            Student studentFromJson = JsonUtil.jsonStudent(studentJson);
            System.out.println(studentFromJson);
        });
    }
}