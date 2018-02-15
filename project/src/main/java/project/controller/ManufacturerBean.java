package project.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import project.model.Manufacturer;
import project.util.JpaUtil;

@ManagedBean
@RequestScoped
public class ManufacturerBean {

	Manufacturer manufacturer = new Manufacturer();

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String FlameManufacturerRegistration() {
		return "ManufacturerRegistration";
	}
	
	public void saveManufacturer() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			em.persist(manufacturer);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
					"Usuário " +this.getManufacturer().getName() +" cadastrado com sucesso.");
			context.addMessage(null, message);
			manufacturer = new Manufacturer();
			em.getTransaction().commit();
		}catch(Exception e){
			
		}finally {
			em.close();
		}
	}
	
	public void deleteManufacturer(Manufacturer manufacturer){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		manufacturer = em.merge(manufacturer);
		em.remove(manufacturer);
		trx.commit();
		em.close();
	}
}
