package keyworddriven;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class Runner {

	public static void main(String[] args) throws Exception {
		//open excel file
		File f=new File("Way2smskwdtestdata.xls");
		//read data in excel
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh1=rwb.getSheet(0);//0 represent sheet1
		int not=rsh1.getRows();
		int nouc1=rsh1.getColumns();
		Sheet rsh2=rwb.getSheet(1);//1 represents sheet2
		int nos=rsh2.getRows();
		int nouc2=rsh2.getColumns();
		//write data in excel
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh1=wwb.getSheet(0);//0 for sheet1
		WritableSheet wsh2=wwb.getSheet(1);//1 for sheet2
		System.out.println(nouc1+" "+nouc2);
		//set date format to result column
		Date dt=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String cname=df.format(dt);
	    Label l1=new Label(nouc1,0,cname);
	    wsh1.addCell(l1);
	    Label l2=new Label(nouc2,0,cname);
	    wsh2.addCell(l2);
	  //create object to methods class
		Methods meth=new Methods();
		//collect all methods in an array
		Method m[]=meth.getClass().getMethods();

	    //1st row for column names so test row index starts with 1
	    for(int i=1;i<not;i++)
	    {
	    	int flag=0;
	    	String tid=rsh1.getCell(0,i).getContents();
	    	String mode=rsh1.getCell(2,i).getContents();
	    	if(mode.equalsIgnoreCase("yes"))
	    	{
	    		for(int j=1;j<nos;j++)
	    		{
	    			String sid=rsh2.getCell(0,j).getContents();
	    			if(tid.equalsIgnoreCase(sid))
	    			{
	    				String mn=rsh2.getCell(2,j).getContents();
	    				String l=rsh2.getCell(3,j).getContents();
	    				String d=rsh2.getCell(4,j).getContents();
	    				String c=rsh2.getCell(5,j).getContents();
	    			  for(int k=0;k<m.length;k++)
	    			  {
	    				  if(m[k].getName().equalsIgnoreCase(mn))
	    				  {
	    					  String r=(String) m[k].invoke(meth,l,d,c);
	    					  if(r.contains("failed")||r.contains("interupted"))
								{
									flag=1;
								}
								Label lb=new Label(nouc2,j,r);
								wsh2.addCell(lb);
								
							}
						}
					}
				}
				if (flag==0)
				{
					Label l=new Label(nouc1,i,"passed");
					wsh1.addCell(l);
					
				}
				else
				{
					Label l=new Label(nouc1,i,"failed");
					wsh1.addCell(l);
				}
			}
			
		}
		wwb.write();
		wwb.close();
	    rwb.close();
				}
		
	    				  
	    			  
	    				
	    			
	    		
	    	}
	    	
	    
	    
	    
		
		
		

	


