package project.model;

public enum SmartObjectSearchType {
	ITEM("Item"),
    CATEGORY("Categoria"),
    CONDITION("Condição"),
    MANUFACTURER("Fabricante"),
    MODEL("Modelo"),
    PURCHASE_DATE("Data da compra"),
    PURCHASE_PRICE("Preço de compra");
	
	SmartObjectSearchType(String smartObject){
        this.smartObject = smartObject;
    }

    //Attributes
    private String smartObject;


    //Properties
    public String getSmartObjectSearchType(){
       return smartObject;
    }
}
