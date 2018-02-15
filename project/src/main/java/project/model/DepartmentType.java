package project.model;

public enum DepartmentType{

    FINANCIAL("Financeiro"),
    JUDICIAL("Jurídico"),
    MARKETING("Marketing"),
    SHOPPING("Compra"),
    DISPOSAL("Venda"),
    ADMINISTRATIVE("Administrativo"),
    OPERATIONAL("Operacional"),
    HUMAN_RESOURCES("Recursos Humanos");

    DepartmentType(String department){
        this.department = department;
    }

    //Attributes
    private String department;


    //Properties
    public String getDepartment(){
       return department;
    }
}
