package io;

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

public class XlsFileReader {
    private XlsFileReader() {
    }

    public static List<University> readUniversity(String filePath) throws IOException {
        List<University> universities = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        String subStr = getSubStr(filePath);
        int universitySheetIndex = 2;

        Iterator<Row> rows = getIteratorRows(inputStream, subStr, universitySheetIndex);
        rows.hasNext();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            University university = new University();
            // filling class object with column values per file rows in a condition
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(currentRow.getCell(4).getStringCellValue()));
            // adding class object into the list
            universities.add(university);
        }
        return universities;
    }

    public static List<Student> readStudent(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        String subStr = getSubStr(filePath);
        int studentSheetIndex = 1;

        Iterator<Row> rows = getIteratorRows(inputStream, subStr, studentSheetIndex);
        rows.hasNext();// skipping top row of column names

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Student student = new Student();
            // filling class object with column values per file rows in a condition
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
            // adding class object into the list
            students.add(student);
        }
        return students;
    }

    private static String getSubStr(String filePath) {
        int dotIndex = filePath.lastIndexOf(".");
        String subStr = filePath.substring(dotIndex + 1);
        return subStr;
    }

    private static Iterator<Row> getIteratorRows(FileInputStream inputStream, String subStr, int sheetIndex) throws IOException {
        Iterator<Row> rows = switch (subStr) {
            case "xlsx" -> getXlsxRows(inputStream, sheetIndex);
            case "xls" -> getXlsRows(inputStream, sheetIndex);
            default -> null;
        };
        // alternate view 01
/*
        if (subStr.equals("xlsx")) {
            return getXlsxRows(inputStream, sheetIndex);
        } else if (subStr.equals("xls")) {
            return getXlsRows(inputStream, sheetIndex);
        } else return rows;
*/
        // alternate view 02
/*
        switch (subStr) {
            case "xlsx":
                rows = getXlsxRows(inputStream, sheetIndex);
                break;
            case "xls":
                rows = getXlsRows(inputStream, sheetIndex);
                break;
            default:
                rows = null;
                break;
        }
*/

        return rows;
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
