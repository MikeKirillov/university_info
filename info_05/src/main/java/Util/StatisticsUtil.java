package Util;

import Enums.StudyProfile;
import Models.Statistics;
import Models.Student;
import Models.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtil {
    private StatisticsUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> studyProfiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        studyProfiles.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(studyProfile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setUniversityCount(profileUniversityIds.size());
            statistics.setUniversityName(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityName(
                            statistics.getUniversityName() + fullNameUniversity + ";"));

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setStudentsCount(profileStudents.size());

            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore((float) BigDecimal.valueOf(value).setScale(
                    2, RoundingMode.HALF_UP).doubleValue()));
        });

        return statisticsList;
    }
}
