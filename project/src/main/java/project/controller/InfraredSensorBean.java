package project.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import project.model.InfraredSensor;
import project.util.JpaUtil;

@ManagedBean
@RequestScoped
public class InfraredSensorBean {

	InfraredSensor infraredSensor = new InfraredSensor();

	public InfraredSensor getInfraredSensor() {
		return infraredSensor;
	}

	public void setInfraredSensor(InfraredSensor infraredSensor) {
		this.infraredSensor = infraredSensor;
	}
	
	public String FlameInfraredSensorRegister() {
		return "InfraredSensorRegister";
	}
	
	public void saveInfraredSensor() {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			em.persist(infraredSensor);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
					"Usuário " +this.getInfraredSensor().getName() +" cadastrado com sucesso.");
			context.addMessage(null, message);
			infraredSensor = new InfraredSensor();
			em.getTransaction().commit();
		}catch(Exception e){
			
		}finally {
			em.close();
		}
	}
	
	public void deleteInfraredSensor(InfraredSensor infraredSensor){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		infraredSensor = em.merge(infraredSensor);
		em.remove(infraredSensor);
		trx.commit();
		em.close();
	}
}
