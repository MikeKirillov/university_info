package io;

import Enums.FileFormat;
import Enums.StudyProfile;
import Models.Student;
import Models.University;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Enums.FileFormat.XLS;
import static Enums.FileFormat.XLSX;

public class XlsFileReader {
    private XlsFileReader() {
    }

    public static List<University> readUniversity(String filePath) throws IOException {
        List<University> universities = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        String subStr = getSubStr(filePath);
        int universitySheetIndex = 2;

        Iterator<Row> rows = getIteratorRows(inputStream, subStr, universitySheetIndex);
        // skipping top row of column names
        rows.next();

        while (rows.hasNext()) {
            Row row = rows.next();
            University university = new University();
            // filling class object with column values per file rows in a condition
            university.setId(row.getCell(0).getStringCellValue());
            university.setFullName(row.getCell(1).getStringCellValue());
            university.setShortName(row.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) row.getCell(3).getNumericCellValue());

            String sp = row.getCell(4).getStringCellValue().toUpperCase().trim();
            if (sp != null && !sp.isBlank()) {
                university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, sp));
            }

            if (!university.isEmpty()) {
                // adding class object into the list
                universities.add(university);
            }
        }
        return universities;
    }

    public static List<Student> readStudent(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        String subStr = getSubStr(filePath);
        int studentSheetIndex = 1;

        Iterator<Row> rows = getIteratorRows(inputStream, subStr, studentSheetIndex);
        // skipping top row of column names
        rows.next();

        while (rows.hasNext()) {
            Row row = rows.next();
            Student student = new Student();
            // filling class object with column values per file rows in a condition
            student.setUniversityId(row.getCell(0).getStringCellValue());
            student.setFullName(row.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) row.getCell(3).getNumericCellValue());
            // adding class object into the list
            students.add(student);
        }
        return students;
    }

    private static String getSubStr(String filePath) {
        int dotIndex = filePath.lastIndexOf(".");
        return filePath.substring(dotIndex + 1);
    }

    private static Iterator<Row> getIteratorRows(FileInputStream inputStream, String subStr, int sheetIndex) throws IOException {
        FileFormat type = FileFormat.getType(subStr);
        if (XLSX == type) {
            return getXlsxRows(inputStream, sheetIndex);
        } else if (XLS == type) {
            return getXlsRows(inputStream, sheetIndex);
        } else {
            throw new IllegalArgumentException("не определен формат файла");
        }
    }

    private static Iterator<Row> getXlsxRows(FileInputStream inputStream, int sheetIndex) throws IOException {
        Iterator<Row> rows;
        XSSFWorkbook xwb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = xwb.getSheetAt(sheetIndex);
        return rows = sheet.iterator();
    }

    private static Iterator<Row> getXlsRows(FileInputStream inputStream, int sheetIndex) throws IOException {
        Iterator<Row> rows;
        HSSFWorkbook hwb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = hwb.getSheetAt(sheetIndex);
        return rows = sheet.iterator();
    }
}