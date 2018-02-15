package project.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import project.model.Rfid;
import project.util.JpaUtil;

@ManagedBean
@RequestScoped
public class RfidBean {

	Rfid rfid = new Rfid();

	public Rfid getRfid() {
		return rfid;
	}

	public void setRfid(Rfid rfid) {
		this.rfid = rfid;
	}
	
	public String FlameRfidRegistration() {
		return "RfidRegistration";
	}
	
	public void saveRfid() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			em.persist(rfid);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
					"Usuário " +this.getRfid().getName() +" cadastrado com sucesso.");
			context.addMessage(null, message);
			rfid = new Rfid();
			em.getTransaction().commit();
		}catch(Exception e){
			
		}finally {
			em.close();
		}
	}
	
	public void deleteRfid(Rfid rfid){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		rfid = em.merge(rfid);
		em.remove(rfid);
		trx.commit();
		em.close();
	}
}
