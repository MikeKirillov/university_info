import Comparator.StudentComparator;
import Comparator.UniversityComparator;
import Enums.StudentComparatorType;
import Enums.UniversityComparatorType;
import Models.FullInfo;
import Models.Statistics;
import Models.Student;
import Models.University;
import Util.ComparatorUtil;
import Util.StatisticsUtil;
import io.JsonWriter;
import io.XlsFileReader;
import io.XlsWriter;
import io.XmlWriter;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private final static String PATH = "/Users/michaelkirillov/IdeaProjects/university_info/" +
            "info_02/src/main/resources/universityInfo.xlsx";

    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(Level.INFO, "Application started, Logger configured");

        List<University> universities = XlsFileReader.readUniversity(PATH);
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);

        List<Student> students = XlsFileReader.readStudent(PATH);
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.log(Level.INFO, "Application finished");
    }
}