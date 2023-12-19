package PCOS_NEW;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class PCOSExcelReader {
	
	
		public static String[][] getData(String sheetname) throws IOException
		{
			String projectDir=System.getProperty("user.dir");
			String path=projectDir+"/src/test/java/PCOS_Testdata/PCOSExcludeList.xlsx";
			File ExcelFile= new File(path);
			FileInputStream FIS= new FileInputStream(ExcelFile);
			XSSFWorkbook workbook= new XSSFWorkbook(FIS);
			XSSFSheet sheet=workbook.getSheet(sheetname);
			int row= sheet.getLastRowNum();
			//System.out.println("rows"+row);
			Row rowcell=sheet.getRow(1);
			int totcol=rowcell.getLastCellNum();
			//System.out.println("column"+totcol);
			DataFormatter format= new DataFormatter();
			String testdata[][]= new String[row][totcol];
			for(int i=1;i<=row;i++)
			{
				for(int j=0;j<totcol;j++)
				{	
					//System.out.println("i"+i);
					//System.out.println("j"+j);
					testdata[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
					//System.out.println(testdata[i-1][j]);
				}
			}
			
			return testdata;
		}
		
		public static int getLastColumn(String sheetname) throws IOException
		{
			String projectDir=System.getProperty("user.dir");
			String path=projectDir+"/src/test/java/PCOS_Testdata/PCOSExcludeList.xlsx";
			File ExcelFile= new File(path);
			FileInputStream FIS= new FileInputStream(ExcelFile);
			XSSFWorkbook workbook= new XSSFWorkbook(FIS);
			XSSFSheet sheet=workbook.getSheet(sheetname);
			int row= sheet.getLastRowNum();
			//System.out.println("rows"+row);
			Row rowcell=sheet.getRow(row);
			int totcol=rowcell.getLastCellNum();
			//System.out.println("column"+totcol);
			//DataFormatter format= new DataFormatter();
			//String testdata[][]= new String[row][totcol];
			
			return totcol+1;
		}
	}