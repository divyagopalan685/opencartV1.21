package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
@DataProvider(name="LoginData")
public String[][] getData()throws IOException
{
	String path=".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from test data
	Excelutils xlutil=new Excelutils(path); //creating an object for XLUtiltity
	int totalRows=xlutil.getRowCount("Sheet1");
	int totalcols=xlutil.getCellCount("Sheet1", 1);
	String logindata[][]=new String[totalRows][totalcols];//created for 2 dimension array
	for(int i=1;i<=totalRows;i++)
	{
			for(int j=0;j<totalcols;j++)
			{
					logindata[i-1][j]=xlutil.getCellData("Sheet1",	i,j); //1,0
			}
	}
		
	return logindata;
	
}

}
