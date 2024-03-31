package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="SenderDetails")
	public String [][] getSenderData() throws IOException
	{
		String path=".//testData/RecipientAndSenderDetails.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("SenderDetails");	
		int totalcols=xlutil.getCellCount("SenderDetails",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("SenderDetails",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	@DataProvider(name="RecipientDetails")
	public String [][] getRecipientData() throws IOException
	{
		String path=".//testData/RecipientAndSenderDetails.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("RecipientDetails");	
		int totalcols=xlutil.getCellCount("RecipientDetails",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("RecipientDetails",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
