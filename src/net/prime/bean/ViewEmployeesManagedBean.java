package net.prime.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;
import org.primefaces.event.RowEditEvent;

import net.prime.model.Employee;

 
@ManagedBean
@SessionScoped
public class ViewEmployeesManagedBean {
    private List<Employee> employees = new ArrayList<Employee>();
    private DataTable dataTable;
 
    public DataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}

	public ViewEmployeesManagedBean(){
 
    }
 
    @PostConstruct
    public void populateEmployeeList(){
        for(int i = 1 ; i <= 10 ; i++){
            Employee emp = new Employee();
            emp.setEmployeeId(String.valueOf(i));
            emp.setEmployeeName("Employee#"+i);
            this.employees.add(emp);
        }
    }
 
    public List<Employee> getEmployees() {
        return employees;
    }
 
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
   
    public void onRowEdit(RowEditEvent event) {
      System.out.println(((Employee)event.getObject()).getEmployeeName());
    }
    
    public void exportPDF(DataTable table) throws IOException {
    	System.out.println("data table:" +table);
        FacesContext context = FacesContext.getCurrentInstance();
        Exporter exporter = new ExtendedPDFExporter();
        exporter.export(context, table, "pdf", false, false, "UTF-8", null, null);
        context.responseComplete();
    }
}