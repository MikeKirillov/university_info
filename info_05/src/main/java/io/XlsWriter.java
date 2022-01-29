package io;

import Models.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    public XlsWriter() {
    }

    public static void writeXlsStatistics(List<Statistics> statisticsList, String filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("Statistics");

        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int rowNumber = 0;
        Row headerRow = statisticsSheet.createRow(rowNumber++);

        Cell studyProfileCellHeader = headerRow.createCell(0);
        studyProfileCellHeader.setCellValue("Study profile");
        studyProfileCellHeader.setCellStyle(headerStyle);

        Cell avgExamScoreCellHeader = headerRow.createCell(1);
        avgExamScoreCellHeader.setCellValue("Average exam score");
        avgExamScoreCellHeader.setCellStyle(headerStyle);

        Cell studentsCountCellHeader = headerRow.createCell(2);
        studentsCountCellHeader.setCellValue("Students count");
        studentsCountCellHeader.setCellStyle(headerStyle);

        Cell universityCountCellHeader = headerRow.createCell(3);
        universityCountCellHeader.setCellValue("University count");
        universityCountCellHeader.setCellStyle(headerStyle);

        Cell universityNameCellHeader = headerRow.createCell(4);
        universityNameCellHeader.setCellValue("University name");
        universityNameCellHeader.setCellStyle(headerStyle);

        for (Statistics statistics : statisticsList) {
            Row dataRow = statisticsSheet.createRow(rowNumber++);

            Cell studyProfileCell = dataRow.createCell(0);
            studyProfileCell.setCellValue(statistics.getStudyProfile().getProfileName());

            Cell avgExamScoreCell = dataRow.createCell(1);
            avgExamScoreCell.setCellValue(statistics.getAvgExamScore());

            Cell studentsCountCell = dataRow.createCell(2);
            studentsCountCell.setCellValue(statistics.getStudentsCount());

            Cell universityCountCell = dataRow.createCell(3);
            universityCountCell.setCellValue(statistics.getUniversityCount());

            Cell universityNameCell = dataRow.createCell(4);
            universityNameCell.setCellValue(statistics.getUniversityName());
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }
}
