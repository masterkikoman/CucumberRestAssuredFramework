package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTests {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> arr = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(
				"C://Users//kalmazan//Desktop//Udemy_RestAssured_Docs//DataDrivenTest.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify the Testcases column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator(); // row is collection of cells
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();

				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
						// desired column
						column = k;
					}

					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {

					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {

							Cell c = cv.next();
							if (c.getCellTypeEnum() == CellType.STRING) {

								arr.add(c.getStringCellValue());
							} else {
								arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}
					}
				}

			}
		}
		return arr;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

}
