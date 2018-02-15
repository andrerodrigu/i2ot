package project.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MegaMenuBean {
	private String orientation = "horizontal";
	 
    public String getOrientation() {
        return orientation;
    }
 
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
