package net.prime.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class ConfirmDialogBean {

	public void destroyWorld(ActionEvent actionEvent) {
		/*
		 * 
		 * do some coding here 
		 * then on completion of your action like database update or delete
		 * add below line to show confirm dialog.
		 * 
		 */
		
		RequestContext.getCurrentInstance().execute("dialogaboutDEQ.show()");
	}
}
