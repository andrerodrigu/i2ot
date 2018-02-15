package project.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import project.model.Consignor;
import project.util.JpaUtil;

@ManagedBean
@RequestScoped
public class ConsignorBean {
	
	Consignor consignor = new Consignor();

	public Consignor getConsignor() {
		return consignor;
	}

	public void setConsignor(Consignor consignor) {
		this.consignor = consignor;
	}
	
	public String FlameConsignorRegister(){
		return "ConsignorRegister";
	}
	
	public void saveConsignor() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			em.persist(consignor);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
					"Usuário " +this.getConsignor().getName() +" cadastrado com sucesso.");
			context.addMessage(null, message);
			consignor = new Consignor();
			em.getTransaction().commit();
		}catch(Exception e){
			
		}finally {
			em.close();
		}
	}
	
	public void deleteConsignor(Consignor consignor){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		consignor = em.merge(consignor);
		em.remove(consignor);
		trx.commit();
		em.close();
	}
}
