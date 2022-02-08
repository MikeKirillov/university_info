package Models;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class FullInfo {

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private static List<University> universityList;

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private static List<Student> studentList;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private static List<Statistics> statisticsList;

    @XmlElement(name = "processedAt")
    private Date processDate;

    public FullInfo() {
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public FullInfo setUniversityList(List<University> universityList) {
        FullInfo.universityList = universityList;
        return this;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public FullInfo setStudentList(List<Student> studentList) {
        FullInfo.studentList = studentList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public FullInfo setStatisticsList(List<Statistics> statisticsList) {
        FullInfo.statisticsList = statisticsList;
        return this;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public FullInfo setProcessDate(Date processDate) {
        this.processDate = processDate;
        return this;
    }
}
